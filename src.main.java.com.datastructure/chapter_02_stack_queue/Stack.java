package com.datastructure.chapter_02_stack_queue;

/**
 * @date : 2019-10-30
 */
public interface Stack<E> {

    int getSize();
    boolean isEmpty();
    void push(E e);
    E pop();
    E peek();
}
