package com.example.hiennv.loigiaihay.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.hiennv.loigiaihay.R;

public class CommonUtils {
    public static int imageId(Context context, String imageName) {
        int imageId = context.getResources().getIdentifier(imageName, "drawable", context.getPackageName());
        return imageId;
    }

    public static void loadImage(Context context, String url, ImageView imageView) {
        RequestOptions requestOptions = new RequestOptions()
                .error(R.drawable.ic_launcher)
                .placeholder(R.drawable.ic_launcher);
        Glide.with(context).load(url).apply(requestOptions).into(imageView);
    }
}
