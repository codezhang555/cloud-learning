package com.itz.cloud.test.CollectionTest;

import org.junit.Test;

import java.util.TreeSet;

/**
 * @author CodeZhang
 * @date 2020/5/5 11:52
 */
public class TreeSetTest {
    /**
     * 1.向TreeSet当中添加的数据，要求是由同一个类的对象。
     */
    @Test
    public void test1(){
        TreeSet set = new TreeSet();
        set.add(123);
        set.add(456);
        set.add("AA");
        set.add(new Person("Tom",12));

    }
}
