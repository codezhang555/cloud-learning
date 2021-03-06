package com.itz.cloud.test.CollectionTest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * 集合元素的遍历，使用迭代器Iterator接口
 * 1.内部的方法： hasNext() 和 next()
 * 2.集合对象每次调用iterator()都得到一个全新的迭代器
 *    默认游标都在集合的第一个元素之前
 * 3.内部定义了remove()，可以在遍历时候删除集合中的元素。此方法不用于集合直接调用remove()
 *
 * @author CodeZhang
 * @date 2020/5/4 13:50
 */
public class IteratorTest {

    @Test
    public void test1(){
        Collection coll = new ArrayList();
        coll.add("AA");
        coll.add("BB");
        coll.add(123);
        coll.add(new String("Tom"));
        coll.add(false);

        Iterator iterator = coll.iterator();
        System.out.println(iterator.next());
        //方式二：不推荐
//        for (int i = 0; i < coll.size(); i++) {
//            System.out.println(iterator.next());
//        }

        //方式三：推荐
        while(iterator.hasNext()){   //判断是否还有下一个元素
            //next():1.指针下移 2.将下移以后集合位置上的元素返回
            System.out.println(iterator.next());
        }
    }

    @Test
    public void test2(){
        Collection coll = new ArrayList();
        coll.add("AA");
        coll.add("BB");
        coll.add(123);
        coll.add(new String("Tom"));
        coll.add(false);

        //错误方式一：  没有这样的元素异常
//        Iterator iterator = coll.iterator();
//        while(iterator.next()!=null){
//            System.out.println(iterator.next());
//        }

        //错误方式二： 死循环
        while(coll.iterator().hasNext()){
            System.out.println(coll.iterator().next());
        }
    }

    //测试Iterator中的remove()
    @Test
    public void test3(){
        Collection coll = new ArrayList();
        coll.add("AA");
        coll.add("BB");
        coll.add(123);
        coll.add(new String("Tom"));
        coll.add(false);

        //删除集合中的某项数据
        //如果还未调用next()或在上一次调用next()方法之后已经调用了remove()方法，再调用remove()会报illegalStateException
        Iterator iterator = coll.iterator();
        while (iterator.hasNext()){
            Object obj = iterator.next();
            if ("Tom".equals(obj)){
                iterator.remove();
            }
        }

        iterator = coll.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }
}
