package com.itz.cloud.juc;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author CodeZhang
 * @ProjectName JavaSourceLearn
 * @Package com.oo.jvm
 * @Version 1.0
 * @date 2020/12/19 17:26
 *
 * 题目：请举例说明集合类是不安全的
 *
 * 1.故障现象
 * java.util.ConcurrentModificationException
 *
 * 2.导致原因
 *
 *
 * 3.解决方案
 *    3.1 Vector  线程安全，性能慢
 *    3.2 Collections.synchronizedList(new ArrayList<>());
 *    3.3 CopyOnWriteArrayList
 *    写时复制
 * CopyOnWrite容器即写时复制的容器。往一个容器添加元素的时候，不直接往当前容器object[]添加，而是先将当前容器object[]进行copy.复制出一个新的容器object[] newElements，
 * 然后新的容器object[ ] newElements里添加元素，添加完元素之后，再将原容器的引用指向新的容器setArray(newElements);
 * 这样做的好处是可以对CopyOnWrite容器进行并发的读，而不需要加锁，因为当前容器不会添加任何元素。所以CopyOnWrite容器也是一种读写分离的思想，读和写不同的容器
 *
 * public boolean add(E e) {
 *         final ReentrantLock lock = this.lock;
 *         lock.lock();
 *         try {
 *             Object[] elements = getArray();
 *             int len = elements.length;
 *             Object[] newElements = Arrays.copyOf(elements, len + 1);
 *             newElements[len] = e;
 *             setArray(newElements);
 *             return true;
 *         } finally {
 *             lock.unlock();
 *         }
 *     }
 *
 * 4.优化的建议(同样的错误，不出现第2次)
 *
 *
 */
public class NotSafeDemo {
    public static void main(String[] args) {

    }

    public static void mapNotSafe(){
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
        //Map<String, String> map1 = Collections.synchronizedMap(new HashMap<>());
        //HashMap<String, String> hashMap = new HashMap<>();
        for (int i = 1; i <= 30; i++) {
            new Thread(()->{
                map.put(Thread.currentThread().getName(), UUID.randomUUID().toString().substring(0, 8));
                System.out.println(map);
            },String.valueOf(i)).start();
        }
    }

    public static void setNotSafe(){
        CopyOnWriteArraySet<String> set = new CopyOnWriteArraySet<>(); //Collections.synchronizedSet(new HashSet<>()); //new HashSet<>();
        //Set<String> set1 = Collections.synchronizedSet(new HashSet<>());
        //HashSet<String> hashSet = new HashSet<>();
        for (int i = 1; i <= 30; i++) {
            new Thread(()->{
                set.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(set);
            },String.valueOf(i)).start();
        }
    }

    public static void listNotSafe(){
        List<String> list = new CopyOnWriteArrayList<>(); //Collections.synchronizedList(new ArrayList<>()); //new Vector(); //new ArrayList<>();
        //List<String> list1 = Collections.synchronizedList(new ArrayList<>());
        //ArrayList<String> arrayList = new ArrayList<>();
        //Vector<String> vector = new Vector<>();
        for (int i = 1; i <= 30; i++) {
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(list);
            },String.valueOf(i)).start();
        }
    }
}
