package com.itz.cloud.test.GenericTest;

import org.junit.Test;

import java.util.Iterator;
import java.util.List;

/**
 * 1.泛型在继承方面的体现
 *
 * 2.通配符的使用
 *
 * @author CodeZhang
 * @date 2020/5/5 13:47
 */
public class GenericTest2 {

    /**
     * 1.泛型在继承方面的体现
     * 虽然类A是类B的父类，但是G<A>和G<B>二者不具备父子关系，是并列关系。
     *
     * 补充：类A是类B的父类，A<G>是B<G>的父类
     *
     *
     * 2.通配符的使用
     *  通配符：？
     *
     *  有限制条件的通配符的使用
     * <? extends Number> (无穷小，Number]
     * 只允许泛型为Number及Number子类的引用调用
     * <? super Number>
     * [Number ,无穷大)
     * 只允许泛型为Number及Number父类的引用调用
     * <? extends Comparable>
     * 只允许泛型为实现Comparable接口的实现类的引用调用
     *
     * ? extends A:
     *      G<? extends A>可以作为G<A> 和G<B>的父类的，其中B是A的子类
     * ? super A:
     *      G<? super A>可以作为G<A> 和G<B>的父类，其中B题A的子类
     *
     *
     */

    @Test
    public void test1(){
        Object obj = null;
        String str = null;

        obj = str;

        Object[] arr1 = null;
        String[] arr2 = null;

        arr1 = arr2;

        List<Object> list1 = null;
        List<String> list2 = null;

    }

    /**
     * 通配符的使用
     *     通配符：？
     *
     * 类A是类B的父类，G<A>,G<B>没有关系，二者共同的父类G<?>
     *
     *     //添加：对于list<?>就不能向其内部添加数据
     *     // 除了添加null之外
     *
     *
     *     //获取(读取)
     */
    @Test
    public void test2(){
        List<Object> list1 = null;
        List<String> list2 = null;

        List<?> list = null;

        list = list1;
        list = list2;

        print(list1);
        print(list2);

    }
    public void print(List<?> list){
        Iterator<?> iterator = list.iterator();
        while (iterator.hasNext()){
            Object obj = iterator.next();
            System.out.println(obj);
        }
    }
}
