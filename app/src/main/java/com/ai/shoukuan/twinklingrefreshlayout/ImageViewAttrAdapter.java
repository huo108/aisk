package com.ai.shoukuan.twinklingrefreshlayout;

import android.databinding.BindingAdapter;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;


public class ImageViewAttrAdapter {
    @BindingAdapter(value = {"imageUrl", "placeHolder", "error"}, requireAll = false)
    public static void loadImage(ImageView imageView, String url, Drawable holderDrawable, Drawable errorDrawable) {
        Glide.with(imageView.getContext())
                .load(url)
                .into(imageView);
    }
}
