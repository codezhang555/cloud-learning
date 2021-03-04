package com.itz.cloud.sort;

import java.util.Arrays;

/**
 * 冒泡排序  时间复杂度为O(n^2)
 * @author CodeZhang
 * @date 2020/5/3 20:55
 */
public class BubbleSort1 {
    public static void main(String[] args) {
        int[] arr = new int[8];
        for (int i = 0; i < 8; i++) {
            arr[i] = (int)(Math.random()*80);
        }
        System.out.println("排序前");
        System.out.println(Arrays.toString(arr));

        BubbleSort(arr);

        System.out.println("排序后");
        System.out.println(Arrays.toString(arr));
    }

    public static void BubbleSort(int[] arr){
        int temp = 0;
        boolean flag = false;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j=0;j< arr.length - i - 1;j++){
                if (arr[j]>arr[j+1]){
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
            if (!flag){
                break;
            }else {
                flag = false;
            }
        }
    }
}
