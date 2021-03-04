package com.itz.cloud.sort;


import java.util.Arrays;

/**
 * 选择排序  时间复杂度O(n^2)
 *
 * @author CodeZhang
 * @date 2020/5/4 10:53
 */
public class SelectSort1 {
    public static void main(String[] args) {
        int[] arr = new int[8];
        for (int i = 0; i < 8; i++) {
            arr[i] = (int)(Math.random()*80);
        }
        System.out.println("排序前");
        System.out.println(Arrays.toString(arr));
//        long startTime = System.currentTimeMillis();
        selectSort(arr);
//        long endTime = System.currentTimeMillis();
//        System.out.println("排序所用时："+(endTime - startTime));
        System.out.println("排序后");
        System.out.println(Arrays.toString(arr));
    }
    
    public static void selectSort(int[] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            int min = arr[i];
            for (int j = i+1;j<arr.length;j++){
                if (min>arr[j]){
                    min = arr[j];
                    minIndex = j;
                }
            }
            System.out.println("arr==="+Arrays.toString(arr));
            if (minIndex!=i){
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
            System.out.println("arr1==="+Arrays.toString(arr));
        }
    }
}

