package com.ai.shoukuan.twinklingrefreshlayout;

import android.databinding.BindingAdapter;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.ai.shoukuan.http.RetrofitClient;
import com.ai.shoukuan.utils.LogAppUtil;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.LazyHeaders;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import com.lcodecore.tkrefreshlayout.utils.LogUtil;

import java.util.List;

import okhttp3.Cookie;


public class ImageViewAttrAdapter {
    @BindingAdapter(value = {"imageUrl", "placeHolder", "error"}, requireAll = false)
    public static void loadImage(ImageView imageView, String url, Drawable holderDrawable, Drawable errorDrawable) {
        LogAppUtil.d("ImageViewAttrAdapter", "url:" + url);
        List<Cookie> cookies = RetrofitClient.cookieJar.getCookieStore().getAllCookie();
        String cookie="";
        if (cookies != null && cookies.size() > 0) {
            cookie = cookies.get(0).toString();
        }
        LogAppUtil.d("ImageViewAttrAdapter", "cookie:" + cookie);
        GlideUrl glideUrl = new GlideUrl(url, new LazyHeaders.Builder().addHeader("Cookie", cookie).build());//cookies.get(0).toString()
        RequestOptions options = new RequestOptions()
                .placeholder(holderDrawable)
                .error(errorDrawable)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .skipMemoryCache(true);
        Glide.with(imageView.getContext())
                .load(glideUrl).listener(new RequestListener<Drawable>() {
            @Override
            public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                return false;
            }

            @Override
            public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                return false;
            }
        }).apply(options).into(imageView);
    }
}
