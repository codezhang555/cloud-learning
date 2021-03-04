package com.itz.cloud.mediumProblem;


/**
 * 两数相加
 * 链接：https://leetcode-cn.com/problems/add-two-numbers/
 * @PackageName: cn.itz.cloud
 * @ClassName: addTwoNumbers
 * @Author: codeZhang
 * @DateTime: 2021/2/4 10:42
 * @Version 1.0
 */
public class addTwoNumbers {


  public static void main(String[] args) {
    ListNode l1 = new ListNode(3,new ListNode(4, new ListNode(2)));
    printList(l1);
    ListNode l2 = new ListNode(4, new ListNode(6, new ListNode(5)));
    printList(l2);
    ListNode listNode = addTwoNumbers1(l1, l2);
    printList(listNode);
  }


  public static void printList(ListNode head){
    ListNode curNode = head;
    while (curNode!=null){
      System.out.print(curNode.val + "->");
      curNode = curNode.next;
    }
  }

  /**
   * 单链表相加
   * @param l1
   * @param l2
   * @return
   */
  public static ListNode addTwoNumbers1(ListNode l1, ListNode l2){
    ListNode head = null,tail = null;
    //进位值
    int carry = 0;
    while (l1 != null || l2 != null){
      int n1 = l1 != null ? l1.val : 0;
      int n2 = l2 != null ? l2.val : 0;
      int sum = n1 + n2 + carry;
      if (head == null){
        head = tail = new ListNode(sum % 10);
      }else {
        tail.next = new ListNode(sum % 10);
        tail = tail.next;
      }
      carry = sum / 10;
      if (l1 != null){
        l1 = l1.next;
      }
      if (l2 != null){
        l2 = l2.next;
      }
    }
    if (carry > 0){
      tail.next = new ListNode(carry);
    }
    return head;
  }
}

/**
 * 单链表
 */
class ListNode{
  int val;
  ListNode next;

  ListNode() {
  }

  ListNode(int val) {
    this.val = val;
  }

  ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }
}
