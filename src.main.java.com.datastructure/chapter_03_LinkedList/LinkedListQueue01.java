package com.datastructure.chapter_03_LinkedList;

import com.datastructure.chapter_02_stack_queue.Queue;

/**
 * @date : 2019-11-5
 */
public class LinkedListQueue01<E> implements Queue<E> {

    public LinkedList<E> list;
    public LinkedListQueue01(){
        list = new LinkedList<>();
    }
    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void enqueue(E e) {
         list.addLast(e);
    }

    @Override
    public E dequeue() {
        return list.removeFirst();
    }

    @Override
    public E getFront() {
        return list.getFirst();
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("LinkedListQueue01: front ");
        sb.append(list);
        return sb.toString();
    }
    public static void main(String[] args){

        LinkedListQueue01<Integer> queue = new LinkedListQueue01<>();
        for(int i = 0 ; i < 10 ; i ++){
            queue.enqueue(i);
            System.out.println(queue);
        }
        for(int i = 0 ; i < 5 ; i ++){
            queue.dequeue();
            System.out.println(queue);
        }
    }
}
