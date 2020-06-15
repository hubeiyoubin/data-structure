package com.datastructure.chapter_03_LinkedList;

import com.datastructure.chapter_02_stack_queue.Queue;

/**
 * @date : 2019-11-5
 */
public class LinkedListQueue<E> implements Queue<E> {

    private class Node {
        public E e;
        public Node next;
        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }
        public Node(E e) {
            this(e, null);
        }
        public Node() {
            this(null , null);
        }
        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public LinkedListQueue() {
        head = null;
        tail = null;
        size = 0;
    }
    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void enqueue(E e) {
       /* if(tail == null){
            tail = new ListNode(e);
            head = tail;
        }else{
            tail.next = new ListNode(e);
            tail = tail.next;
        }
        size ++;*/
       if(tail == null){
           tail = new Node(e);
           head = tail;
       }else{
           tail.next = new Node(e);
           tail = tail.next;
       }
       size ++;
    }

    @Override
    public E dequeue() {
        if(this.isEmpty()){
            throw new IllegalArgumentException("queue is empty");
        }
        Node node  = head;
        head = head.next;
        node.next = null;
        if(head == null)
            tail = null;
        size --;
        return node.e;
    }

    @Override
    public E getFront() {
        if(this.isEmpty()){
            throw new IllegalArgumentException("queue is empty");
        }
        return head.e;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LinkedListQueue: front ");
        Node cur = head;
        while(cur != null){
            sb.append(cur.e);
            sb.append("-> ");
            cur = cur.next;
        }

        sb.append("null tail");

        return sb.toString();
    }

    public static void main(String[] args) {
        LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<>();
        for(int i = 0; i < 10; i++) {
            linkedListQueue.enqueue(i);
            System.out.println(linkedListQueue);
        }

        for(int j = 0; j < 11; j ++){
            linkedListQueue.dequeue();
            System.out.println(linkedListQueue);
        }
    }
}
