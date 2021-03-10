package com.itz.cloud.ms;

/**
 * @PackageName: com.itz.cloud.ms
 * @ClassName: ProblemTest
 * @Author: codeZhang
 * @DateTime: 2021/3/10 10:29:30
 * @Version 1.0
 */
public class ProblemTest {
  public static void main(String[] args) {
    float s2 = 3.4F;
    //3.4 双精度数，double类型，转换成float类型属于向下转型，会造成精度损失
//    float s2 = 3.4;
    System.out.println("s2 = " + s2);

    short s1 = 1;
    // 1是int类型，所以运算结果是int类型，需要强制转换才能赋值给short类型
//    s1 = s1 + 1;
    //相当于 s1= (short)(s1+1); 有隐含的强制类型转换
    s1 +=1;

    Integer a = new Integer(3);
    Integer b = 3;  // 自动装箱为Integer类型
    int c = 3;
    System.out.println(a == b);  // 引用非同一个类型
    System.out.println(a == c);  // a自动拆箱int类型进行比较

    Integer f1 = 100,f2 = 100,f3 = 150,f4 = 150;
    //看Integer.valueOf()方法
    System.out.println("f1 == f2 = " + (f1 == f2));
    System.out.println("f3 == f4 = " + (f3 == f4));
  }
}
