package com.itz.cloud.sort;

import java.util.Arrays;

/**
 * 插入排序
 *
 * @author CodeZhang
 * @date 2020/5/4 12:02
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {101,34,119,1};

        insertSort(arr);
    }

    public static void insertSort(int[] arr){
        //使用for循环来简化代码
        for (int i=1;i<arr.length;i++){
            //定义待插入的数
            int insertVal = arr[i];
            int insertIndex = i - 1;
            //给insertVal 找到插入的位置
            //1.insertIndex>=0保证给insertVal找插入位置时，不越界
            //2.insertVal<arr[insertIndex]待插入的数还没有找到插入位置
            //3.需要将arr[insertIndex]后移
            while (insertIndex>=0 && insertVal<arr[insertIndex]){
                arr[insertIndex+1] = arr[insertIndex];
                insertIndex --;
            }
            //当退出while循环时，说明插入的位置找到，insertIndex+1
            arr[insertIndex+1] = insertVal;

            System.out.println("第"+i+"轮后：");
            System.out.println(Arrays.toString(arr));
        }
    }
}
