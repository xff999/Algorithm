package com.xff2.Hot20;

import java.util.Arrays;

/**
 * @author xff
 * @createTime 2022/6/16 15:18

给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点

输入：head = [1,2,3,4,5], n = 2
输出：[1,2,3,5]

输入：head = [1], n = 1
输出：[]

输入：head = [1,2], n = 1
输出：[1]
 */

/*   思路  （两个指针，两个距离为 n  让他们移动 当后一个指向 null  则前一个 的后面一个元素是言删除的）

      采取双重遍历肯定是可以解决问题的，但题目要求我们一次遍历解决问题，那我们的思路得发散一下。

        我们可以设想假设设定了双指针 p 和 q 的话，当 q 指向末尾的 NULL，
             p 与 q 之间相隔的元素个数为 n 时，那么删除掉 p 的下一个指针就完成了要求。
        设置虚拟节点 dummyHead 指向 head
        设定双指针 p 和 q，初始都指向虚拟节点 dummyHead
        移动 q，直到 p 与 q 之间相隔的元素个数为 n
        同时移动 p 与 q，直到 q 指向的为 NULL
        将 p 的下一个节点指向下下个节点  */


public class c19_删除链表的倒数第n个节点 {

    public static void main(String[] args) {
        ListNode head5 = new ListNode(5);
        ListNode head4 = new ListNode(4,head5);
        ListNode head3 = new ListNode(3,head4);
        ListNode head2 = new ListNode(2,head3);
        ListNode head1 = new ListNode(1,head2);
        ListNode end =removeNthFromEnd(head1, 2);
        int [] a = new int[4];
        int i=0;
        while (end !=null){
            a[i] =end.val;
            end = end.next;
            i++;
        }
        System.out.println(Arrays.toString(a));
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);  //初始化第一个位置
        dummy.next = head; //指向 head
        ListNode p =dummy; //前面的
        ListNode q =dummy;  //后面的指针

        for (int i = 0; i <= n ; i++) {
            q=q.next; //让两个指针 间隔两个元素 （移动三次）
        }
     //两个指针 整体的向后移动
        while(q !=null){ //条件 q 为null 停止
            p=p.next;
            q=q.next;
        }
        //做删除
         ListNode del = p.next ;
         p.next = del.next;

        return dummy.next ;
    }

    //使用统计 总数，再次遍历得到要删除的位置，有问题 错误的
    /*public static ListNode removeNthFromEnd(ListNode head, int n) {
                        //传入头结点的list   和倒数第n 个
         //先遍历 得到长度，再进行删除节点
        int total = 0;
        ListNode star = head;
        while (star !=null){
            total++;
            star=star.next;

        }
        System.out.println("total "+total);
        int k =0 ;//记录当前的个数
        ListNode t = head;
        while (t !=null){
            k++;
            if( k ==total-n){
                t.next = t.next.next; //向后跨越 删除元素
                break;
            }
            t=t.next;
        }

          return head;
    }*/


}

class ListNode {
    int val; //节点的值
    ListNode next;  //指向下一个节点
    ListNode() {}  //三个构造函数
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
