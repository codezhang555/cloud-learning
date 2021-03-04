package com.itz.cloud;

import okhttp3.OkHttpClient;

/**
 * @author CodeZhang
 * @ProjectName cloud-learning
 * @Package com.itz.cloud
 * @Version 1.0
 * @date 2021/3/4 23:48
 */
public class OkHttpStaticFactory {
    //静态工厂注入实例
    private static OkHttpClient okHttpClient;
    public static OkHttpClient getInstance(){
        if (okHttpClient == null){
            okHttpClient = new OkHttpClient.Builder().build();
        }
        return okHttpClient;
    }
}
