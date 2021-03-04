package com.itz.cloud.sort;

/**
 * 二分查找
 * @PackageName: com.itz.cloud.sort
 * @ClassName: BinarySelect
 * @Author: codeZhang
 * @DateTime: 2021/2/26 9:46
 * @Version 1.0
 */
public class BinarySelect {
  public static void main(String[] args) {
    int[] arr = new int[]{1,3,5,7,9,11,13,15,17};
    System.out.println(BinarySelectTest(arr, 13));
  }

  public static int BinarySelectTest(int[] arr,int n){
    int low = 0;
    int high = arr.length - 1;
    int mid;
    while (low <= high){
      mid = (low + high) / 2;
      if (arr[mid] == n){
        return mid;
      }else if (arr[mid] < n){
        low = mid + 1;
      }else {
        high = mid - 1;
      }
    }
    return -1;
  }
}
