package com.itz.cloud.easyProblem;

/**
 * 回文数
 * 链接：https://leetcode-cn.com/problems/palindrome-number/
 * @PackageName: cn.itz.cloud.easyProblem
 * @ClassName: isPalindrome
 * @Author: codeZhang
 * @DateTime: 2021/2/5 13:51
 * @Version 1.0
 */
public class isPalindrome {

  public static void main(String[] args) {
    int x = 989;
    System.out.println(isPalindrome1(x));
  }

  public static boolean isPalindrome1(int x){
    if (x < 0){
      return false;
    }
    int cur = 0;
    int num = x;
    while (num != 0){
      cur = cur * 10 + num % 10;
      num /= 10;
    }
    return cur == x;
  }
}
