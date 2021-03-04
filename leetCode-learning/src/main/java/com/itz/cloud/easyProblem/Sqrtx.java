package com.itz.cloud.easyProblem;


/**
 * 二分查找
 * x的平方根
 * 链接：https://leetcode-cn.com/problems/sqrtx/
 * @PackageName: com.itz.cloud.easyProblem
 * @ClassName: Sqrtx
 * @Author: codeZhang
 * @DateTime: 2021/2/26 14:15
 * @Version 1.0
 */
public class Sqrtx {
  public static void main(String[] args) {
    int x = 10;
    System.out.println(mySqrt(x));
  }

  static int mySqrt(int x){
    int left = 0;
    int right = x;
    if (x == 1){
      return 1;
    }
    while (right - left > 1){
      int mid = left + (right - left) / 2 ;
      if (x / mid < mid){
        right = mid;
      }else {
        left = mid;
      }
    }
    return left;
  }
}
