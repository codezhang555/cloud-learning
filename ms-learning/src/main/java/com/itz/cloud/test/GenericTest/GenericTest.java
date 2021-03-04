package com.itz.cloud.test.GenericTest;

import org.junit.Test;

import java.util.*;

/**
 * 泛型的使用
 * 1.jdk5.0新增的特性
 *
 * 2.在集合中使用泛型
 *  总结：
 *  1.集合按口或集合类在jdk5.0时都修改为带泛型的结构。
 *  2.在实例化集合类时，可以指明具体的泛型类型
 *  3.指明完以后，在集合类或按口中凡是定义类或按口时，内部结构使用到类的泛型的位置（比如方法，构造器、属性等），都指定为实例化时泛型的类型
 *    比如add(E e)  ---> 实例化以后，add(Integer e)
 *  4.泛型的类型必须是类，不能是基本数据类型，需要使用到基本数据类型的位置，需要使用包装类
 *
 *
 *
 * @author CodeZhang
 * @date 2020/5/5 12:42
 */
public class GenericTest {

    //在集合中使用泛型之前的情况
    @Test
    public void test1(){
        ArrayList list = new ArrayList();
        //存放学生的成绩
        list.add(77);
        list.add(80);
        list.add(68);
        list.add(88);
        //问题一：类型不安全
        list.add("Tom");

        for(Object score:list){
            //问题二：强转时，出现类型转换异常
            int stuScore = (int)score;
            System.out.println(stuScore);
        }
    }

    //在集合中使用泛型的情况
    @Test
    public void test2(){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(77);
        list.add(79);
        list.add(80);
        list.add(78);
        //编译时，就会使用类型检查，保证数据的安全
        System.out.println(list);
    }

    @Test
    public void test3(){
        Map<String,Integer> map = new HashMap<>();
        map.put("AA",123);
        map.put("BB",13);
        map.put("CC",11);
        map.put("DD",12);

        Set<Map.Entry<String, Integer>> entry = map.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator = entry.iterator();
        while(iterator.hasNext()){
            Map.Entry<String, Integer> e = iterator.next();
            System.out.println(e);
        }
    }

    /**
     * 泛型方法：在方法中出现了泛型的结构，泛型参数与类的泛型参数没有任何关系
     * 泛型方法所属的类是不是泛型类都没有关系
     * 泛型方法在调用时，指明泛型参数的类型
     */
}
