package com.datastructure.chapter_03_LinkedList;

/**
 * @date : 2019-10-31
 */
public class LinkedList01<E> {

    private class Node{
        public E e;
        public Node next;
        public Node(E e,Node next){
            this.e = e;
            this.next = next;
        }
        public Node(E e){
            this(e,null);
        }
        public Node(){
            this(null,null);
        }
        @Override
        public String toString(){
            return e.toString();
        }
    }

    private int size;
    private Node head;

    public LinkedList01(){
        head = null;
        size = 0;
    }
    // 获取链表中的元素个数
    public int getSize(){
        return size;
    }

    // 返回链表是否为空
    public boolean isEmpty(){
        return size == 0;
    }

    // 在链表头添加新的元素e addFirst
    public void addFirst(E e){
        Node node = new Node(e);
        node.next = head;
        head = node;

        //head = new ListNode(e, head);
        size ++;
    }

    // 在链表的index(0-based)位置添加新的元素e
    public void add(int index ,E e){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("Add failed. Illegal index.");
        }
        if(index == 0){
            addFirst(e);
        }else{
            Node prev = head;
            for(int i = 0; i < index - 1; i++){
                prev = prev.next;
            }
            Node node = new Node(e);
            node.next = prev.next;
            prev.next = node;
            //prev.next = new ListNode(e,prev.next);
            size ++;
        }


    }

    // 在链表末尾添加新的元素e  addLast
    public void addLast(E e){
        add(size,e);
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("LinkedList01: ");
        sb.append(String.format("size = %d, ",size));
        Node cur = head;
        while(cur != null){
            sb.append(cur.e);
            sb.append("-> ");
            cur = cur.next;
        }
        sb.append("null");
        return sb.toString();
    }

    public void removeElements(Integer val) {
        while(head != null && head.e.equals(val)){
            Node delNode = head;
            head = head.next;
            delNode.next = null;
            size --;
        }
        if(head == null)
            return ;

        Node cur = head;
        while(cur.next != null){
            if(cur.next.e.equals(val)){
                Node delNode = cur.next;
                cur.next = delNode.next;
                delNode.next = null;
                size --;
            }else{
                cur = cur.next;
            }
        }
    }

    public void removeElements_02(Integer val) {
        while(head != null && head.e.equals(val)){
            head = head.next;
            size --;
        }
        Node cur = head;
        if(cur == null)
            return;
        while (cur.next != null){
            if(cur.next.e.equals(val)){
                cur.next = cur.next.next;
                size --;
            }else{
                cur = cur.next;
            }
        }
    }

    public void removeElements_03(Integer val) {
        Node dummyHead = new Node(null,this.head);
        Node cur = dummyHead;
        while(cur.next != null){
            if(cur.next.e.equals(val)){
                cur.next = cur.next.next;
                size --;
            }else{
                cur = cur.next;
            }
        }
    }



}
