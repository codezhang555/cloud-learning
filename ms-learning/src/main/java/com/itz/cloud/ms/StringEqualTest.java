package com.itz.cloud.ms;

/**
 * 1.String对象的intern()会得到字符串对象在常量池中对应版本的引用(如果常量池中有一个字符串与String对象的equals结果是true)
 *   如果常量池中没有对应的字符串，则该字符串将被添加到常量池中，然后返回常量池中字符串的引用；
 * 2.字符串的+操作其本质是创建了 StringBuilder 对象进行 append 操作，然后将拼接后的 StringBuilder 对象用
 * toString 方法处理成 String 对象，这一点可以用 javap -c StringEqualTest.class命令获得 class 文件对应的 JVM 字节码指令就可以看出来
 * @PackageName: com.itz.cloud.ms
 * @ClassName: StringEqualTest
 * @Author: codeZhang
 * @DateTime: 2021/3/10 16:23:26
 * @Version 1.0
 */
public class StringEqualTest {
  public static void main(String[] args) {
    String s1 = "programming";
    String s2 = new String("programming");
    String s3 = "program";
    String s4 = "ming";
    String s5 = "program" + "ming";
    String s6 = s3 + s4;
    System.out.println("(s1 == s2) = " + (s1 == s2));
    System.out.println("(s1 == s5) = " + (s1 == s5));
    System.out.println("(s1 == s6) = " + (s1 == s6));
    System.out.println("(s1 == s6.intern()) = " + (s1 == s6.intern()));
    System.out.println("(s2 == s2.intern()) = " + (s2 == s2.intern()));
  }
}
