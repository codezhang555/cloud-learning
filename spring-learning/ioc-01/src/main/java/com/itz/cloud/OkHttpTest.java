package com.itz.cloud;

import okhttp3.*;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @author CodeZhang
 * @ProjectName cloud-learning
 * @Package com.itz.cloud
 * @Version 1.0
 * @date 2021/3/4 23:42
 */
public class OkHttpTest {
    public static void main(String[] args) {
//        OkHttpClient okHttpClient = new OkHttpClient.Builder().build();
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        OkHttpClient okHttpClient = ctx.getBean("okHttpClient", OkHttpClient.class);
        Request request = new Request.Builder()
                .get()
                .url("http://www.baidu.com")
                .build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                System.out.println("e.getMessage() = " + e.getMessage());
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                System.out.println("response.body().string() = " + response.body().string());
            }
        });

    }
}
