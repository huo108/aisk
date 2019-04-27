package com.ai.shoukuan.ui.history;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.ai.shoukuan.BR;
import com.ai.shoukuan.R;
import com.ai.shoukuan.databinding.ActivityBillHistoryBinding;
import com.ai.shoukuan.factory.AppViewModelFactory;
import com.mvvm.library.base.BaseActivity;
import com.mvvm.library.utils.MaterialDialogUtils;
import com.mvvm.library.utils.ToastUtils;

import me.tatarka.bindingcollectionadapter2.BindingRecyclerViewAdapter;

public class BillHistoryActivity extends BaseActivity<ActivityBillHistoryBinding, NetWorkViewModel> {

    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_bill_history;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }

    @Override
    public NetWorkViewModel initViewModel() {
        //使用自定义的ViewModelFactory来创建ViewModel，如果不重写该方法，则默认会调用NetWorkViewModel(@NonNull Application application)构造方法
        AppViewModelFactory factory = AppViewModelFactory.getInstance(getApplication());
        return ViewModelProviders.of(this, factory).get(NetWorkViewModel.class);
    }

    @Override
    public void initData() {
        //给RecyclerView添加Adpter，请使用自定义的Adapter继承BindingRecyclerViewAdapter，重写onBindBinding方法，里面有你要的Item对应的binding对象。
        // Adapter属于View层的东西, 不建议定义到ViewModel中绑定，以免内存泄漏
        binding.setAdapter(new BindingRecyclerViewAdapter());
        //请求网络数据
        viewModel.requestNetWork();
    }

    @Override
    public void initViewObservable() {
        //监听下拉刷新完成
        viewModel.uc.finishRefreshing.observe(this, new Observer() {
            @Override
            public void onChanged(@Nullable Object o) {
                //结束刷新
                binding.twinklingRefreshLayout.finishRefreshing();
            }
        });
        //监听上拉加载完成
        viewModel.uc.finishLoadmore.observe(this, new Observer() {
            @Override
            public void onChanged(@Nullable Object o) {
                //结束刷新
                binding.twinklingRefreshLayout.finishLoadmore();
            }
        });
        //监听删除条目
        viewModel.deleteItemLiveData.observe(this, new Observer<NetWorkItemViewModel>() {
            @Override
            public void onChanged(@Nullable final NetWorkItemViewModel netWorkItemViewModel) {
                int index = viewModel.getItemPosition(netWorkItemViewModel);
                //删除选择对话框
                MaterialDialogUtils.showBasicDialog(BillHistoryActivity.this, "提示", "是否删除【" + netWorkItemViewModel.entity.get().getName() + "】？ position：" + index)
                        .onNegative(new MaterialDialog.SingleButtonCallback() {
                            @Override
                            public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                ToastUtils.showShort("取消");
                            }
                        }).onPositive(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        viewModel.deleteItem(netWorkItemViewModel);
                    }
                }).show();
            }
        });
    }

//    private ActivityBillHistoryBinding binding;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        binding = DataBindingUtil.setContentView(this, R.layout.activity_bill_history);
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        List<BindingAdapterItem> items = new ArrayList<>();
//        for (int i = 0; i < 10; i++) {
//            BillBean billBean = new BillBean();
//            billBean.setType("收款");
//            billBean.setSource("来源:微信收款");
//            billBean.setTime(sdf.format(new Date()));
//            billBean.setMoney("+50000");
//            items.add(billBean);
//        }
//        BillAdapter adapter = new BillAdapter();
//        adapter.setItems(items);
//        LinearLayoutManager manager = new LinearLayoutManager(getApplicationContext());
//        binding.billRecycler.setLayoutManager(manager);
//        binding.billRecycler.setAdapter(adapter);
//        adapter.notifyDataSetChanged();
//    }


}
