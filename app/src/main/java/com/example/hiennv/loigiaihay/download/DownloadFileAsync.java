package com.example.hiennv.loigiaihay.download;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

import com.example.hiennv.loigiaihay.R;
import com.example.hiennv.loigiaihay.callback.PostDownload;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import timber.log.Timber;

public class DownloadFileAsync extends AsyncTask<String, String, String> {
    public static final int DIALOG_DOWNLOAD_PROGRESS = 0;
    private PostDownload postDownload;
    private Context context;
    private FileDescriptor fileDescriptor;
    private File file;
    private String fileLocation;
    private ProgressDialog progressDialog;

    public DownloadFileAsync(Context context, String fileLocation, PostDownload postDownload) {
        this.context = context;
        this.postDownload = postDownload;
        this.fileLocation = fileLocation;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog = new ProgressDialog(context);
        progressDialog.setCancelable(false);
        progressDialog.setMessage(context.getResources().getString(R.string.txt_downloading));
        progressDialog.create();
        progressDialog.show();
    }

    @Override
    protected void onProgressUpdate(String... values) {
        super.onProgressUpdate(values);
        Timber.i("%s", values[0]);
    }

    @Override
    protected String doInBackground(String... strings) {
        int count;
        try {
            URL url = new URL(strings[0]);
            URLConnection connection = url.openConnection();
            connection.connect();

            int lenghtOfFile = connection.getContentLength();
            Timber.i("%s", "Length of the file: " + lenghtOfFile);

            InputStream input = new BufferedInputStream(url.openStream());
            file = new File(fileLocation);
            FileOutputStream output = new FileOutputStream(file); //context.openFileOutput("content.zip", Context.MODE_PRIVATE);
            Timber.i("%s", "file saved at " + file.getAbsolutePath());
            fileDescriptor = output.getFD();

            byte data[] = new byte[1024];
            long total = 0;
            while ((count = input.read(data)) != -1) {
                total += count;
                publishProgress("" + (int) ((total * 100) / lenghtOfFile));
                output.write(data, 0, count);
            }

            output.flush();
            output.close();
            input.close();
        } catch (Exception e) {
            Timber.e("%s", e.getMessage());
        }
        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
        if (postDownload != null) {
            postDownload.downloadDone(file);
        }
    }
}
