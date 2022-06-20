package com.xff2.Hot20;

import java.util.Arrays;

/**
 * @author xff
 * @createTime 2022/6/16 20:34
将两个升序链表合并为一个新的 升序 链表并返回。
     新链表是通过拼接给定的两个链表的所有节点组成的。

输入：l1 = [1,2,4], l2 = [1,3,4]
输出：[1,1,2,3,4,4]

输入：l1 = [1,2,4], l2 = [1,3,4]
输出：[1,1,2,3,4,4]

输入：l1 = [], l2 = [0]
输出：[0]
 */
public class c21_合并两个有序链表 {
    public static void main(String[] args) {
//        ListNode head3 = new ListNode(4);
//        ListNode head2 = new ListNode(2,head3);
//        ListNode head1 = new ListNode(1,head2);
//
//        ListNode head23 = new ListNode(4);
//        ListNode head22 = new ListNode(3,head23);
//        ListNode head21 = new ListNode(1,head22);
        ListNode head21 = new ListNode(1);
        ListNode head1 = null;


        ListNode listNode = mergeTwoLists(head1, head21);
        int [] a = new int[10];
        int i=0;
        while (listNode !=null){
            a[i] =listNode.val;
            listNode = listNode.next;
            i++;
        }
        System.out.println(Arrays.toString(a));

    }

    //ListNode 在别的类中已经定义了，同包下可以使用
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode buff = new ListNode(-1); //结果链表的 首结点
        ListNode  newList = buff;
                 //buff 前面的标志
        while (list1 !=null && list2 !=null){ //全部不为空  与的关系
            if(list1.val<=list2.val){ //lis1 的值比较小 ，连接放入结果链表
                newList.next=list1;
                list1=list1.next; //向下移动
                newList = newList.next; //更新结果的
            } else {
                newList.next=list2;
                list2=list2.next;
                newList = newList.next;
            }
         }
        //在判断是否还存在元素
        while(list1 !=null){
            newList.next=list1;
            list1=list1.next;
            newList =newList.next;
        }
        while(list2 !=null){
            newList.next=list2;
            list2=list2.next;
            newList =newList.next;
        }

        return buff.next;
    }
}
