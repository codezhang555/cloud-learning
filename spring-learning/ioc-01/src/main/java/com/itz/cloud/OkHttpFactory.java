package com.itz.cloud;

import okhttp3.OkHttpClient;

/**
 * @author CodeZhang
 * @ProjectName cloud-learning
 * @Package com.itz.cloud
 * @Version 1.0
 * @date 2021/3/4 23:53
 */
public class OkHttpFactory {

    //实例工厂注入实例
    private OkHttpClient okHttpClient;

    public OkHttpClient getInstance(){
        if (okHttpClient == null){
            okHttpClient = new OkHttpClient.Builder().build();
        }
        return okHttpClient;
    }
}
