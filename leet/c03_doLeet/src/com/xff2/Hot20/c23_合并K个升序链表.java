package com.xff2.Hot20;


import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author xff
 * @createTime 2022/6/19 18:44

给你一个链表数组，每个链表都已经按升序排列。
请你将所有链表合并到一个升序链表中，返回合并后的链表。
输入：lists = [[1,4,5],[1,3,4],[2,6]]
输出：[1,1,2,3,4,4,5,6]
解释：链表数组如下：
[
1->4->5,
1->3->4,
2->6
]
将它们合并到一个有序链表中得到。
1->1->2->3->4->4->5->6

输入：lists = []
输出：[]

输入：lists = [[]]
输出：[]
 */

//主要在于 链表的个数 是k 个  可以使用 分治的方法， 把个数逐渐缩小，直到为一个
//2.顺序合并，县合并两个，然后存入结果中，再用结果和其他的剩余的合并 得到结果


public class c23_合并K个升序链表 {

    public static void main(String[] args) {
        ListNode head3 = new ListNode(5);
        ListNode head2 = new ListNode(4,head3);
        ListNode head1 = new ListNode(1,head2);

        ListNode head23 = new ListNode(4);
        ListNode head22 = new ListNode(3,head23);
        ListNode head21 = new ListNode(1,head22);

        ListNode head32 = new ListNode(6);
        ListNode head31 = new ListNode(2,head32);

        ListNode[] lists = {head1,head21,head31};

        ListNode end = mergeKLists(lists) ;  //得到头结点

        while(end!=null){  //遍历输出结点的 val
            System.out.print(end.val+ " ");
            end=end.next;
        }


    }
    //1.使用队列，可比较性的队列，先得到所有的元素在 队列中，然后再去添加到链表
    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> queue =  //这是一种优先队列的方式 （具有优先级）
                new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
                    @Override  //重写的比较的方法 ，表示队列元素是可以比较的
                    public int compare(ListNode o1, ListNode o2) {
                        if (o1.val < o2.val) return -1;
                        else if (o1.val == o2.val) return 0;
                        else return 1;
                    }
                });
          //设置标志 结点
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;  //p 和他 指向同一个头结点，p 开始向后添加
        for (ListNode node : lists) {  //把k个链表 都放入队列中
            if (node != null) queue.add(node);
        }
        while (!queue.isEmpty()) { //再从队列中 出元素，（看结点是否 还有链接 的元素）
            ListNode minNode = queue.poll();  //得到一个小元素
            p.next=minNode;  //p  放入 这个小元素
            p = minNode;  //p 向后移动
            if (minNode.next!=null){  //判断这个元素  后面是否链接结点
                queue.add(minNode.next);  //有的话 就添加一次
            }

        }
        //while 循环结束 ，表示 每个都是单个结点 并且有序的

        return dummy.next;
    }


    //2.顺序合并，县合并两个，然后存入结果中，再用结果和其他的剩余的合并 得到结果
/*
    public static ListNode mergeKLists(ListNode[] lists) {
        ListNode ans = null;
        for (int i = 0; i < lists.length; ++i) {
            ans = mergeTwoLists(ans, lists[i]);
        }
        return ans;
    }

    public static ListNode mergeTwoLists(ListNode a, ListNode b) {
        if (a == null || b == null) {
            return a != null ? a : b;
        }

        ListNode head = new ListNode(0);
        ListNode tail = head, aPtr = a, bPtr = b;
        while (aPtr != null && bPtr != null) {
            if (aPtr.val < bPtr.val) {
                tail.next = aPtr;
                aPtr = aPtr.next;
            } else {
                tail.next = bPtr;
                bPtr = bPtr.next;
            }
            tail = tail.next;
        }
        tail.next = (aPtr != null ? aPtr : bPtr);
        return head.next;
    }*/


}
