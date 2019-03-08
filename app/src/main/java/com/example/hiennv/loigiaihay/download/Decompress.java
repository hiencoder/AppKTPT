package com.example.hiennv.loigiaihay.download;

import android.content.Context;


import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import timber.log.Timber;

public class Decompress {
    private File zipFile;
    private InputStream zipInputStream;
    private Context context;
    private static final String ROOT_LOCATION = "/sdcard";
    private static final String TAG = "HienNV";

    /**
     * @param context
     * @param zipFile
     */
    public Decompress(Context context, File zipFile) {
        this.context = context;
        this.zipFile = zipFile;

        dirChecker("");
    }

    /**
     * @param context
     * @param zipInputStream
     */
    public Decompress(Context context, InputStream zipInputStream) {
        this.context = context;
        this.zipInputStream = zipInputStream;
        dirChecker("");
    }

    //Unzip file
    public void unzip() {
        try {
            Timber.i("%s", "Starting to unzip!");
            InputStream inputStream = zipInputStream;
            if (inputStream == null) {
                inputStream = new FileInputStream(zipFile);
            }
            ZipInputStream zis = new ZipInputStream(inputStream);
            ZipEntry zipEntry = null;
            while ((zipEntry = zis.getNextEntry()) != null) {
                Timber.i("Unziping: %s", zipEntry.getName());

                if (zipEntry.isDirectory()) {
                    dirChecker(ROOT_LOCATION + "/" + zipEntry.getName());
                } else {
                    FileOutputStream fos = new FileOutputStream(new File(ROOT_LOCATION, zipEntry.getName()));
                    //ByteArrayOutputStream
                }
            }
        } catch (Exception e) {
            Timber.e("Unzip with error: %s", e.getMessage());
        }
    }
//https://gist.github.com/dhavaln/7c7e3a95442a1a3e6af3
    //https://androidroadies.blogspot.com/2013/09/unzipping-files-with-android.html
    /**
     * @param dir
     */
    private void dirChecker(String dir) {

    }
}
