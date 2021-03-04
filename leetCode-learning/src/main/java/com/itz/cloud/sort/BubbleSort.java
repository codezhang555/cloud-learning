package com.itz.cloud.sort;


/**
 * 冒泡排序  测试一下冒泡排序的速度(O(n^2)),给80000个数据，
 *
 * @author CodeZhang
 * @date 2020/5/3 19:40
 */
public class BubbleSort {
    public static void main(String[] args) {
       // int arr[] = {3,9,-1,10,-2};

//        System.out.println("排序前数组");
//        System.out.println(Arrays.toString(arr));

        //测试一下冒泡排序的速度(O(n^2)),给80000个数据，测试
        //创建一个80000个随机的数组
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int)(Math.random()*80000); //生成一个[0,8000000)的随机数
        }
        long startTime = System.currentTimeMillis();
        //测试冒泡排序
        BubbleSort(arr);

        long endTime = System.currentTimeMillis();

//        System.out.println("排序后的数组：");
//        System.out.println(Arrays.toString(arr));
        System.out.println("执行时间："+(endTime - startTime));
//        //第一趟排序，就是将最大的数排在最后
//        for (int i = 0; i < arr.length - 1; i++) {
//            //如果前面的数比后面的数大，则交换
//            if (arr[i] > arr[i+1]){
//                temp = arr[i];
//                arr[i] = arr[i+1];
//                arr[i+1] = temp;
//            }
//        }

//        //第二趟排序，就是将最大的数排在最后
////
////        for (int i = 0; i < arr.length - 1 - 1; i++) {
////            //如果前面的数比后面的数大，则交换
////            if (arr[i] > arr[i+1]){
////                temp = arr[i];
////                arr[i] = arr[i+1];
////                arr[i+1] = temp;
////            }
////        }
////        System.out.println("第二趟排序后的数组");
////        System.out.println(Arrays.toString(arr));
    }

    //将冒泡排序算法，封装成一个方法
    public static void BubbleSort(int[] arr){
        //冒泡排序的时间复杂度O(n^2)
        int temp = 0; //临时变量
        boolean flag = false;  //标识变量，表示是否进行过交换
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length -1 - i; j++) {
                //如果前面的数比后面的数大，则交换
                if (arr[j] > arr[j+1]){
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
//            System.out.println("第"+(i+1)+"趟排序后的数组");
//            System.out.println(Arrays.toString(arr));

            if (!flag){  //在一趟排序中，一次交换都没有发生
                break;
            }else{
                flag = false; //重置flag，进行下次判断
            }
        }
    }
}
