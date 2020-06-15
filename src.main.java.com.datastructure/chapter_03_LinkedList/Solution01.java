package com.datastructure.chapter_03_LinkedList;

/**
 * @date : 2019-11-5
 */
/// Leetcode 203. Remove Linked List Elements
/// https://leetcode.com/problems/remove-linked-list-elements/description/

/*    删除链表中等于给定值 val 的所有节点。

            示例:

            输入: 1->2->6->3->4->5->6, val = 6
            输出: 1->2->3->4->5*/
public class Solution01 {

    public ListNode removeElements(ListNode head, int val) {
        while(head != null && head.val == val){
            ListNode delNode = head;
            head = head.next;
            delNode.next = null;
        }
        if(head == null){
            return head;
        }

        ListNode cur = head;
        while(cur.next != null){
            if(cur.next.val == val){
                ListNode delNode = cur.next;
                cur.next = delNode.next;
                delNode.next = null;
            }else{
                cur = cur.next;
            }
        }
        return head;
    }


    public ListNode removeElements_re(ListNode head, int val) {
        if(head == null)
            return head;
        head.next = removeElements_re(head.next, val);
        System.out.println("head :"+ head);
        return head.val == val ? head.next : head;
  /*      if(head.val == val)
            return res;
        else{
            head.next = res;
            return head;
        }*/
    }


    public ListNode removeElements_debug(ListNode head, int val, int depth) {

        String depthString = generateDepthString(depth);

        System.out.print(depthString);
        System.out.println("Call: remove " + val + " in " + head);

        if(head == null){
            System.out.print(depthString);
            System.out.println("Return: " + head + "---");
            return head;
        }

        ListNode res = removeElements_debug(head.next, val, depth + 1);
        System.out.print(depthString);
        System.out.println("After remove " + val + ": " + head.next);

        ListNode ret;
        if(head.val == val)
            ret = res;
        else{
            head.next = res;
            ret = head;
        }
        System.out.print(depthString);
        System.out.println("Return: " + ret);

        return ret;
    }

    private String generateDepthString(int depth){
        StringBuilder res = new StringBuilder(depth+"");
        for(int i = 0 ; i < depth ; i ++)
            res.append("--");
        return res.toString();
    }
    public static void main(String[] args) {
/*        LinkedList01<Integer> list = new LinkedList01<>();
        for(int i = 0; i < 10; i ++) {
            list.addLast(i);
        }
        for(int i = 0; i < 3; i ++) {
            list.addLast(i);
        }
        System.out.println(list);
        list.removeElements_03(2);
        System.out.println(list);*/

        int[] nums = {1, 2, 6, 3};
        ListNode head = new ListNode(nums);
        System.out.println(head);

        ListNode res = (new Solution01()).removeElements_debug(head,2, 1);
        System.out.println(res);

    }
}
