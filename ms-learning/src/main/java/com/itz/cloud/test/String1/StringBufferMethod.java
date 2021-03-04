package com.itz.cloud.test.String1;

import org.junit.Test;

/**
 * StringBuffer类常用方法:
 * StringBuffer append(xxx):提供了很多的append()方法，用于进行字符串拼接
 * StringBuffer delete(int start,int end):删除指定位置的内容
 * StringBuffer replace(int start, int end, String str): 把[start,end)位 置替换为str
 * StringBuffer insert(int offset, xxx):在指定位置插入xxx
 * StringBuffer reverse():把当前字符序列逆转StringBuffer append(xx):提供了很多的append()方法，用于进行字符串拼接
 * public int indexOf(String str)
 * public String substring(int start,int end):返回一个从start开始到end结束的左闭右开的字符串
 * public int length()
 * public char charAt(int n)
 * public void setCharAt(int n ,char ch)
 *
 * 总结：
 *  增：append(xxx)
 *  删：delete(int start,int end)
 *  改：replace(int start, int end, String str)/setCharAt(int n ,char ch)
 *  查：charAt(int n)
 *  插：insert(int offset, xxx)
 *  长度：length()
 *  遍历：for + charAt()
 *
 *
 * @author CodeZhang
 * @date 2020/5/1 20:16
 */
public class StringBufferMethod {

    @Test
    public void test1(){
        StringBuffer s1 = new StringBuffer("abc");
        s1.append(1);
        s1.append('c');
        System.out.println(s1);
        //s1.delete(2,4);   //左闭右开
        //s1.replace(2,4,"hello");
        //s1.insert(2,false);
        //s1.reverse();
        String s2 = s1.substring(1, 3);
        System.out.println(s1);
        System.out.println(s1.length());
        System.out.println(s2);
    }

    /**
     * 对比String、StringBuffer、StringBuilder三者的效率
     *
     * 效率从高到低排列：StringBuilder > StringBuffer > String
     */
    @Test
    public void test2(){
        long startTime = 0L;
        long endTime = 0L;
        String text = "";
        StringBuffer buffer = new StringBuffer("");
        StringBuilder builder = new StringBuilder("");
        //开始对比
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            buffer.append(String.valueOf(i));
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuffer的执行时间："+(endTime - startTime));
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            builder.append(String.valueOf(i));
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuilder的执行时间："+(endTime - startTime));
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            text = text + i;
        }
        endTime = System.currentTimeMillis();
        System.out.println("String的执行时间："+(endTime - startTime));

    }
}
