package com.itz.cloud.test.CollectionTest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

/**
 * foreach() JDK5.0新增，增强for循环，用于遍历集合、数组
 *
 * @author CodeZhang
 * @date 2020/5/4 14:18
 */
public class ForTest {
    @Test
    public void test1(){
        Collection coll = new ArrayList();
        coll.add("AA");
        coll.add("BB");
        coll.add(123);
        coll.add(new String("Tom"));
        coll.add(false);

        //for(集合中元素的类型 局部变量：集合对象)
        //内部仍然调用了迭代器
        for(Object obj : coll){
            System.out.println(obj);
        }
    }

    @Test
    public void test2(){
        int[] arr = new int[]{5,3,4,2,1};
        //for(数组中元素的类型 局部变量：数组对象)
        for (int i : arr){
            System.out.println(i);
        }
    }


    @Test
    public void test3(){
        String[] arr = new String[]{"MM","MM","MM"};

//        //普通for循环
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = "GG";
//        }

        //方式二：增强for循环
        for(String s : arr){
            s = "GG";   //重新定义的变量，修改，不会改变原有的值
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
