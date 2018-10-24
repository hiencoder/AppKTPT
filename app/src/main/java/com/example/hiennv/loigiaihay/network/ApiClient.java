package com.example.hiennv.loigiaihay.network;

import com.example.hiennv.loigiaihay.utils.AppConstants;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static Retrofit retrofit = null;

    private static OkHttpClient okHttpClient;

    public static Retrofit getClient() {
        if (okHttpClient == null) {
            initOkHttpClient();
        }
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(AppConstants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .client(okHttpClient)
                    .build();
        }
        return retrofit;
    }

    private static void initOkHttpClient() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(AppConstants.REQUEST_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(AppConstants.REQUEST_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(AppConstants.REQUEST_TIMEOUT, TimeUnit.SECONDS)
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request original = chain.request();
                        Request.Builder builder = original.newBuilder()
                                .addHeader("Accept", "application/json")
                                .addHeader("Request-Type", "Android")
                                .addHeader("Content-Type", "application/json");
                        Request request = builder.build();
                        return chain.proceed(request);
                    }
                })
                .build();

    }
}
