package com.itz.cloud.sort;


import java.util.Arrays;

/**
 * 选择排序
 *
 * @author CodeZhang
 * @date 2020/5/4 10:36
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] arr = {101,3,1,100};

        SelectSort1(arr);

    }

    public static void SelectSort1(int[] arr){
        int minIndex = 0;
        int min = arr[0];  //假定最小值
        //第一轮
        for (int j =0+1;j<arr.length;j++){
            if (min>arr[j]){   //说明假定的最小值，不是最小的
                min = arr[j];  //重置min
                minIndex = j;  //重置minIndex
            }
        }
        if (minIndex != 0){
            arr[minIndex] = arr[0];
            arr[0] = min;
        }
        System.out.println("第一轮");
        System.out.println(Arrays.toString(arr));

        minIndex = 1;
        min = arr[1];
        //第二轮
        for (int j =1+1;j<arr.length;j++){
            if (min>arr[j]){   //说明假定的最小值，不是最小的
                min = arr[j];  //重置min
                minIndex = j;  //重置minIndex
            }
        }
        if (minIndex != 1){
            arr[minIndex] = arr[1];
            arr[1] = min;
        }
        System.out.println("第二轮");
        System.out.println(Arrays.toString(arr));

        minIndex = 2;
        min = arr[2];
        //第三轮
        for (int j =2+1;j<arr.length;j++){
            if (min>arr[j]){   //说明假定的最小值，不是最小的
                min = arr[j];  //重置min
                minIndex = j;  //重置minIndex
            }
        }
        if (minIndex != 2){
            arr[minIndex] = arr[2];
            arr[2] = min;
        }
        System.out.println("第三轮");
        System.out.println(Arrays.toString(arr));
    }
}
