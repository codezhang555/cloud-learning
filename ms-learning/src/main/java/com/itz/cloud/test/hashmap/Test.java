package com.itz.cloud.test.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * @author CodeZhang
 * @version 1.0
 * @date 2020/4/16 15:29
 */
public class Test {
    public static void main(String[] args) {
        Map<String, Double> hashmap = new HashMap<>();

        hashmap.put("k1",0.1);
        hashmap.put("k2",0.2);
        hashmap.put("k3",0.3);
        hashmap.put("k4",0.4);

        System.out.println(hashmap.get("k1"));
    }
}
