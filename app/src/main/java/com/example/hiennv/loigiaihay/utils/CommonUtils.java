package com.example.hiennv.loigiaihay.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.hiennv.loigiaihay.R;

import java.io.File;

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

    /*Get folder size*/
    public static long getFolderSize(File file){
        long size = 0;
        if (file != null && file.isDirectory()){
            //get list file in folder
            File[] listFile = file.listFiles();
            if (listFile != null){
                //If directory contains the file
                for (File file1: listFile) {
                    //if file1 is file
                    if (file1.isFile()) {
                        size += file1.length();
                    }else {
                        //if file1 is a directory
                        size += getFolderSize(file1);
                    }
                }
            }
        }
        return size;
    }
}
