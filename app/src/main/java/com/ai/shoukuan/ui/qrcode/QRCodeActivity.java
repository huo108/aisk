package com.ai.shoukuan.ui.qrcode;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.databinding.DataBindingUtil;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.ai.shoukuan.R;
import com.ai.shoukuan.bean.UploadResult;
import com.ai.shoukuan.databinding.ActivityQrcodeBinding;
import com.ai.shoukuan.http.ApiService;
import com.ai.shoukuan.http.RetrofitClient;
import com.ai.shoukuan.upload.ProgressRequestBody;

import java.io.File;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class QRCodeActivity extends Activity implements View.OnClickListener {

    private ActivityQrcodeBinding binding;
    private ApiService mApi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_qrcode);
        binding.qrcodeImg.setOnClickListener(this);
        binding.upload.setOnClickListener(this);
        binding.include.back.setOnClickListener(this);
        binding.include.text.setText(getResources().getText(R.string.qrcode));
        mApi = RetrofitClient.getInstance().create(ApiService.class);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.qrcode_img:
                chooseAlbums();
                break;
            case R.id.upload:
                uploadPicture();
                break;
            case R.id.back:
                finish();
                break;
        }
    }

    public void chooseAlbums() {
        if (ActivityCompat.checkSelfPermission(QRCodeActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(QRCodeActivity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
        }
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setDataAndType(MediaStore.Images.Media.INTERNAL_CONTENT_URI, "image/*");//相片类型
        startActivityForResult(intent, 1);
    }

    private String picturePath;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case 1:
                Uri selectedImage = data.getData();
                String[] filePathColumn = {MediaStore.Images.Media.DATA};
                Cursor cursor = getContentResolver().query(selectedImage, filePathColumn, null, null, null);
                cursor.moveToFirst();
                int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                picturePath = cursor.getString(columnIndex);
                cursor.close();
                Bitmap bm = BitmapFactory.decodeFile(picturePath);
                binding.qrcodeImg.setImageBitmap(bm);
                binding.qrcodeImg.setClickable(false);
                break;
        }
    }


    private void uploadPicture() {
        binding.flCircleProgress.setVisibility(View.VISIBLE);
        File file = new File(picturePath);
        //是否需要压缩
        //实现上传进度监听
        ProgressRequestBody requestFile = new ProgressRequestBody(file, "image/*", new ProgressRequestBody.UploadCallbacks() {
            @Override
            public void onProgressUpdate(int percentage) {
                binding.circleProgress.setProgress(percentage);
            }

            @Override
            public void onError() {
            }

            @Override
            public void onFinish() {
            }
        });

        MultipartBody.Part body =
                MultipartBody.Part.createFormData("file", file.getName(), requestFile);

        mApi.upload(body).enqueue(new Callback<UploadResult>() {
            @Override
            public void onResponse(Call<UploadResult> call, Response<UploadResult> response) {
                binding.flCircleProgress.setVisibility(View.GONE);
                UploadResult resp = response.body();
                if (resp != null) {
                    Toast.makeText(QRCodeActivity.this, "图片上传成功！", Toast.LENGTH_SHORT).show();
                    binding.uploadText.setVisibility(View.GONE);
                    binding.upload.setVisibility(View.GONE);
                }
            }

            @Override
            public void onFailure(Call<UploadResult> call, Throwable t) {
                binding.flCircleProgress.setVisibility(View.GONE);
                Toast.makeText(QRCodeActivity.this, "图片上传失败，请重试", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
