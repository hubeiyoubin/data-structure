package com.datastructure.chapter_07_Heap_Priority_Queue;

import com.datastructure.chapter_02_stack_queue.Queue;

/**
 * @date : 2019-12-21
 */
public class PriorityQueue<E extends Comparable<E>> implements Queue<E> {

    private MaxHeap<E> maxHeap;

    public PriorityQueue(){
        maxHeap = new MaxHeap<>();
    }

    @Override
    public int getSize() {
        return maxHeap.size();
    }

    @Override
    public boolean isEmpty() {
        return maxHeap.size() == 0;
    }

    @Override
    public void enqueue(E e) {
        maxHeap.add(e);
    }

    @Override
    public E dequeue() {
        E e = maxHeap.extractMax();
        return e;
    }

    @Override
    public E getFront() {
        return maxHeap.findMax();
    }

}
