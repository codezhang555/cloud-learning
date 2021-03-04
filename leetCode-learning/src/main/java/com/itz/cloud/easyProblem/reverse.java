package com.itz.cloud.easyProblem;

/**
 * 整数反转
 * 链接：https://leetcode-cn.com/problems/reverse-integer/
 * @PackageName: cn.itz.cloud.easyProblem
 * @ClassName: reverse
 * @Author: codeZhang
 * @DateTime: 2021/2/4 16:09
 * @Version 1.0
 */
public class reverse {
  public static void main(String[] args) {
    int x = 1534236469;
    int i = reverseInt(x);
    System.out.println(i);
  }

  public static int reverseInt(int x){
    int rev = 0;
    while (x != 0){
      int pop = x % 10;  //取余
      x = x / 10;   //去最后一位
      //判断是否溢出
      if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > Integer.MAX_VALUE % 10)){
        return 0;
      }
      if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < Integer.MIN_VALUE % 10)){
        return 0;
      }
      rev = rev * 10 + pop;
    }
    return rev;
  }
}
