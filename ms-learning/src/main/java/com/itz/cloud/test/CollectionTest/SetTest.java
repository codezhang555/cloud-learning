package com.itz.cloud.test.CollectionTest;

import org.junit.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * 1.Set接口的框架结构
 * |------Collection接口：单列集合，用来存储一个一个的对象
 *       |-----Set接口：无序的，不可重复的数据  -->高中讲的"集合"
 *          |----HashSet：作为set接口的主要实现类；线程不安全；可以存储null值
 *               |----LinkedHashSet：作为HashSet的子类；遍历其内部数据时，可以按照添加的顺序遍历
 *                    优点：对于频繁的遍历操作，LinkedHashSet效率高于HashSet
 *          |----TreeSet：可以按照添加对象的指定属性进行排序
 *
 * 2.Set接口中没有定义新的方法，使用的都是Collection中定义的方法
 *
 * 3.要求：向Set中添加的数据，其所在的类一定要重写equals()和hashCode(Object obj)
 *   要求：重写的hashCode()和equals()尽可能保持一致性，以实现对象相等规则，即：“相等的对象必须具有相等的散列码“
 *
 *
 *
 * @author CodeZhang
 * @date 2020/5/4 16:02
 */
public class SetTest {
    /**
     * 一、Set：存储无序的，不可重复的数据
     * 1.无序性:不等于随机性，存储的数据在底层数组中并非按照数组索引的顺序添加，而是根据数据的哈希值
     *
     * 2.不可重复性：保证添加的元素按照equals()判断时，不能返回true，即：相同的元素只能添加一个
     *
     * 二、添加元素的过程，以HashSet为例
     *    向HashSet中添加元素a,首先调用元素a所在类的hashCode()方法，计算元素a的哈希值，
     *    此哈希值通过计算算出在hashSet底层数组中的存放位置（即为：索引位置），判断数组此
     *    位置上是否已经有元素：
     *       如果此没位置没有元素，则元素a添加成功  -->情况一
     *       如果此位置上有其他元素b(或以链表形式存在的多个元素)，则比较元素a与元素b的hash值
     *         如果hash值不相同，则元素a添加成功  -->情况二
     *         如果hash值相同，调用元素a所在类的equals():
     *              equals()返回true,元素a添加失败
     *              equals()返回false,则元素a添加成功  --情况三
     *
     *    对于添加成功的情况2和情况3而言：元素a与已经存在指定索引位置上的数据以链表的方式存储
     *    jdk7:元素a放到数组中，指向原来的元素   头插法
     *    jdk8:原来的元素在数组中，指向元素a    尾插法
     *      七上八下
     *
     *
     */
    @Test
    public void test1(){
        Set set = new HashSet();
        set.add(123);
        set.add(456);
        set.add("AA");
        set.add("CC");
        set.add(new Person("Tom",21));
        set.add(new Person("Tom",21));
        set.add(129);

        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    /**
     * LinkedHashSet的使用
     * LinkedHashSet作为HashSet的子类，在添加数据的同时，每个数据还维护了两个引用，记录此数据的前一根数据，后一根数据
     * 优点：对于频繁的遍历操作，LinkedHashSet效率高于HashSet
     */
    @Test
    public void test2(){

    }
}
