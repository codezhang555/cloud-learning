package com.itz.cloud.dataStructure;

import com.itz.cloud.pojo.ArrayQueue;

import java.util.Scanner;

/**
 * 队列：
 * 1.队列是一个有序列表，可以用数组或是链表来实现
 * 2.遵循先入先出的原则。即：先存入队列的数据，要先取出。后存入的后取出
 * @PackageName: cn.itz.cloud.dataStructure
 * @ClassName: ArrayQueue
 * @Author: codeZhang
 * @DateTime: 2021/2/4 14:32
 * @Version 1.0
 */
public class ArrayQueueDemo {
  public static void main(String[] args) {
    //创建一个队列
    ArrayQueue queue = new ArrayQueue(3);
    char key = ' '; //接收用户输入
    Scanner scanner = new Scanner(System.in);
    boolean loop = true;
    //输出一个菜单
    while (loop){
      System.out.println("s(show):显示队列");
      System.out.println("e(exit):退出程序");
      System.out.println("a(add):添加数据到队列");
      System.out.println("g(get):从队列取出数据");
      System.out.println("h(head):查看队列头的数据");
      key = scanner.next().charAt(0);
      switch (key){
        case 's':
          queue.showQueue();
          break;
        case 'a':
          System.out.println("输出一个数");
          int value = scanner.nextInt();
          queue.addQueue(value);
          break;
        case 'g':
          try {
            int res = queue.getQueue();
            System.out.printf("取出的数据是%d\n",res);
          } catch (Exception e) {
            System.out.println(e.getMessage());
          }
          break;
        case 'h':
          try {
            int res = queue.headQueue();
            System.out.println("队列头的数据是");
          } catch (Exception e) {
            System.out.println(e.getMessage());
          }
          break;
        case 'e':
          scanner.close();
          loop = false;
          break;
        default:
          break;
      }
    }
    System.out.println("程序退出");
  }
}
