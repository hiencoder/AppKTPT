package com.example.hiennv.loigiaihay.utils;

import android.content.Context;

public class CommonUtils {
    public static int imageId(Context context, String imageName){
        int imageId = context.getResources().getIdentifier(imageName,"drawable",context.getPackageName());
        return imageId;
    }
}
