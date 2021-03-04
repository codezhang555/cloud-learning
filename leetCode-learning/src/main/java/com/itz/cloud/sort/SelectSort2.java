package com.itz.cloud.sort;

import java.util.Arrays;

/**
 * @author CodeZhang
 * @date 2020/5/4 11:21
 */
public class SelectSort2 {
    public static void main(String[] args) {
        int[] arr = new int[7];
        for (int i = 0; i < 7; i++) {
            arr[i] = (int)(Math.random()*80);
        }
        System.out.println("排序前");
        System.out.println(Arrays.toString(arr));

        SelectSort(arr);

        System.out.println("排序后");
        System.out.println(Arrays.toString(arr));
    }

    public static void SelectSort(int[] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            int min =arr[i];
            for (int j=i+1;j<arr.length;j++){
                if (min>arr[j]){
                    min=arr[j];
                    minIndex=j;
                }
            }
            if (minIndex!=i){
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
        }
    }
}
