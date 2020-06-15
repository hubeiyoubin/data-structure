package com.datastructure.chapter_03_LinkedList;

import com.datastructure.chapter_02_stack_queue.Stack;

/**
 * @date : 2019-11-5
 */
public class LinkedListStack<E> implements Stack<E> {
    private LinkedList<E> linkedList;
    public LinkedListStack(){
        linkedList = new LinkedList<>();
    }

    @Override
    public int getSize() {
        return linkedList.getSize();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    @Override
    public void push(E e) {
        linkedList.addFirst(e);
    }

    @Override
    public E pop() {
        return linkedList.removeFirst();
    }

    @Override
    public E peek() {
        return linkedList.getFirst();
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("linkedStack : top  ");
        sb.append(linkedList);
        return sb.toString();
    }
    public static void main(String[] args) {
        LinkedListStack<Integer> linkedListStack = new LinkedListStack<>();
        for(int i = 0; i < 10; i ++){
            linkedListStack.push(i);
            System.out.println(linkedListStack);
        }
        for(int j = 0; j < 11; j ++){
            linkedListStack.pop();
            System.out.println(linkedListStack);
        }

    }
}
