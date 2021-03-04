package com.itz.cloud.pojo;

/**
 * 使用数组模拟队列
 * @PackageName: cn.itz.cloud.pojo
 * @ClassName: ArrayQueue
 * @Author: codeZhang
 * @DateTime: 2021/2/4 14:35
 * @Version 1.0
 */
public class ArrayQueue {
  private int maxSize;  //数组最大容量
  private int front;  //队列头
  private int rear; //队列尾
  private int[] arr;  //该数据用于存放数据，模拟队列

  //创建队列的构造器
  public ArrayQueue(int arrMaxSize) {
    this.maxSize = arrMaxSize;
    arr = new int[maxSize];
    this.front = -1;
    this.rear = -1;
  }

  //判断队列是否满
  public boolean isFull(){
    return rear == maxSize -1;
  }

  //判断队列是否为空
  public boolean isEmpty(){
    return rear == front;
  }

  //添加数据到队列
  public void addQueue(int n){
    //判断队列是否满
    if (isFull()){
      System.out.println("队列满，不能添加数据");
      return;
    }
    rear ++;
    arr[rear] = n;
  }

  //获取队列的数据，出队列
  public int getQueue(){
    if (isEmpty()){
      throw new RuntimeException("队列空，不能取数据");
    }
    front ++;
    return arr[front];
  }

  //显示队列所有数据
  public void showQueue(){
    if (isEmpty()){
      System.out.println("队列空，无数据");
      return;
    }
    for (int i = 0; i < arr.length; i++) {
      System.out.printf("arr[%d]=%d\n",i,arr[i]);
    }
  }

  //显示队列头数据，不是取出数据
  public int headQueue(){
    if (isEmpty()){
      throw new RuntimeException("队列空，无数据");
    }
    return arr[front + 1];
  }
}
