package com.itz.cloud.test.msTest;

/**
 * 面试总结:  == 和 equals区别
 *   == ：
 *       基本类型： 比较值是否相等
 *       引用类型： 比较引用是否相等
 *   equals：
 *        本质上是值比较，只不过是String和Integer重写了equals()方法
 * @PackageName: com.itz.cloud.ms
 * @ClassName: StringMsTest
 * @Author: codeZhang
 * @DateTime: 2021/3/3 9:42:31
 * @Version 1.0
 */
public class EqualsTest {
  public static void main(String[] args) {
    String x = "string";
    String y = "string";
    String z = new String("string");
    System.out.println(x==y); // x和y指向同一个引用
    System.out.println(x==z);  // new String 重新开辟了内存空间
    System.out.println(x.equals(y));
    System.out.println(x.equals(z));
  }
}
