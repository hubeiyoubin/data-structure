package com.datastructure.chapter_02_stack_queue;

/**
 * @date : 2019-10-30
 */
public interface Queue<E> {

    int getSize();
    boolean isEmpty();
    void enqueue(E e);
    E dequeue();
    E getFront();
}
