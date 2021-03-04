package com.itz.cloud.easyProblem;

import java.util.Arrays;

/**
 * 两数之和
 * 链接：https://leetcode-cn.com/problems/two-sum/
 * @PackageName: cn.itz.cloud
 * @ClassName: twoSum
 * @Author: codeZhang
 * @DateTime: 2021/2/4 10:32
 * @Version 1.0
 */
public class twoSum {
  public static void main(String[] args) {
    int[] nums = {2,7,11,15};
    int target = 18;
    int[] ints = twoSum1(nums, target);
    System.out.println(Arrays.toString(ints));
  }

  public static int[] twoSum1(int[] nums, int target) {
    for (int i = 0; i < nums.length; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        if (nums[i] + nums[j] == target) {
          return new int[]{i, j};
        }
      }
    }
    return new int[0];
  }
}

