package com.itz.cloud.easyProblem;

/**
 * 二分查找
 * 两数之和 II - 输入有序数组
 * 链接：https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/
 * @PackageName: com.itz.cloud.easyProblem
 * @ClassName: TwoSumInputArrayIsSorted
 * @Author: codeZhang
 * @DateTime: 2021/3/1 15:58
 * @Version 1.0
 */
public class TwoSumInputArrayIsSorted {
  public static void main(String[] args) {
    int[] numbers = {2, 4, 6, 8};
    int[] sum = twoSum(numbers, 10);
    for (int i = 0; i < sum.length; i++) {
      System.out.println(sum[i]);
    }
  }

  public static int[] twoSum(int[] numbers,int target){
    int min = 0;
    int max = numbers.length-1;
    while (min<max){
      int sum = numbers[min] + numbers[max];
      if (sum == target){
        return new int[]{min+1,max+1};
      }else if (sum > target){
        max --;
      }else {
        min++;
      }
    }
    return null;
  }

}
