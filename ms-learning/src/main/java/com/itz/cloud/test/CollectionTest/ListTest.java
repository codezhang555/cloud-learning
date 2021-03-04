package com.itz.cloud.test.CollectionTest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * 1.list接口框架：
 * |------Collection接口：单列集合，用来存储一个一个的对象
 *      |-----List接口：有序的，可重复的数据  -->“动态"数组,替换原有的数组
 *          |----ArrayList：作为list接口的主要实现类,线程不安全的、效率高；
 *               底层使用object[] elementData存储
 *          |----LinkedList：对于频繁的插入、删除操作、使用此类效率比ArrayList高；
 *               底层使用双向链表存储
 *          |----Vector:作为list接口的古老实现类，线程安全的、效率低；
 *               底层使用object[] elementData存储
 *
 * 2.ArrayList源码分析：
 *    2.1 jdk7情况下： 饿汉式
 *       ArrayList list = new ArrayList(); //底层创建了长度是10的Object[]数组elementData
 *       list.add(123); //elementDate[0]=123;
 *       ...
 *       list.add(11); //如果此次添加导致底层elementData的数组容量不够，则扩容。
 *         默认情况下，扩容为原来容量的1.5倍，同时将原有数组数据复制到新的数组中
 *
 *       结论：建议开发中使用带参的构造器：ArrayList list = new ArrayList(int capacity)
 *
 *    2.2 jdk8中ArrayList的变化： 懒汉式
 *       ArrayList list = new ArrayList(); //底层Object[] elementData初始化为{},并没有创建长度
 *       list.add(123); //第一次调用add()时，底层才创建了长度10的数组，并将数据123添加到elementData中
 *       ...
 *       后续的添加与扩容与jdk7一样
 *    2.3 小结：jdk7中的ArrayList对象的创建类似于单例的饿汉式 ，而Jdk8中的ArrayList的对象的创建类似于单例的懒汉式，
 *             延迟了数组的创建，节省了内存。
 *
 * 3.LinkedList源码分析：底层使用双向链表存储
 *       LinkedList list = new LinkedList(); 内部声明了first和last属性，默认值为null
 *       list.add(123); 将123封装到Node中，创建了Node对象
 *
 * 4.Vector的源码分析：jdk7和jdk8中通过Vector()构造器创建对象时，底层都创建了长度为10的数组
 *                   在扩容方面，默认扩容为原来的数组长度的2倍
 *
 *
 * 5.list接口中的常用方法：
 *
 *
 *  面试题:ArrayList、LinkedList、Vector三者的异同？
 *  同：三个类都是事先了list接口，存储数据的特点相同：存储有序的、可重复的数据
 *  不同：见上
 *
 * @author CodeZhang
 * @date 2020/5/4 14:29
 */
public class ListTest {

    /**
     * void add(int index, Object ele):在index位置插入ele元素
     * boolean addAll(int index, Collection eles):从index位置开始将eles中的所有元未添加进来
     * Object get(int index):获取指定index位置的元素
     * int indexOf(Object obj):返回obj在集合中首次出现的位置
     * int lastIndex(Object obj):返回obj在当前集合中术次出现的位置
     * Object remove(Int index):移除指定index位置的元素，并返回此元素
     * Object set(int index, Object ele):设置指定index位置的元素为ele
     * List subList(int fromIndex, int tolndex):返回从fromIndex到tolndex位置的子集合
     *
     * 常用方法：
     * 增:add(Object obj)
     * 删:remove(int index) / remove(Object obj)
     * 改:set(int index, Object ele)
     * 查:get(int index)
     * 插:add(int index, Object ele)
     * 长度:size()
     * 遍历:1.Iterator迭代器方式
     *     2.增强for循环
     *     3.普通的循环
     */

    @Test
    public void test1(){
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add("AA");
        list.add(new Person("Tom",12));
        list.add(new String("jerry"));

        System.out.println(list);

        //void add(int index, Object ele):在index位置插入ele元素
        list.add(1,"BB");
        System.out.println(list);

        //boolean addll(jint index, Collection eles):从index位置开始将eles中的所有元未添加进来
        List list1 = Arrays.asList(1,2,3);
        list.addAll(list1);
        System.out.println(list);
    }

    @Test
    public void test2(){
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add("AA");

        //方式一：Iterator迭代器
        Iterator iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        //方式二：增强for循环
        for(Object obj:list){
            System.out.println(obj);
        }

        //方式三：普通for循环
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

    }


}
