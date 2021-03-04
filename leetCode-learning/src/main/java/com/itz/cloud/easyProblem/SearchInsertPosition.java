package com.itz.cloud.easyProblem;

/**
 * 二分查找
 * 搜索插入位置
 * 链接：https://leetcode-cn.com/problems/search-insert-position/
 * @PackageName: com.itz.cloud.easyProblem
 * @ClassName: SearchInsertPosition
 * @Author: codeZhang
 * @DateTime: 2021/2/26 13:58
 * @Version 1.0
 */
public class SearchInsertPosition {
  public static void main(String[] args) {
    int[] arr = new int[]{1,3,5,7,9};
    System.out.println(searchInsert(arr, 8));
  }

  public static int searchInsert(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;
    while (left <= right) {
      //防止内存溢出
      int mid = left + (right - left) / 2;
      if (nums[mid] == target){
        return mid;
      }else if(nums[mid] > target){
        right = mid - 1;
      }else {
        left = mid + 1;
      }
    }
    //此时left = right
    return left;
  }
}
