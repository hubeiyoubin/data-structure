package com.datastructure.chapter_02_stack_queue;

/**
 * @date : 2019-10-30
 *  在这一版LoopQueue的实现中，我们将不浪费那1个空间：）
 */
public class LoopQueueWithoutWaste<E> implements Queue<E> {

    private E[] data;
    private int size;
    private int front;
    private int tail;

    public LoopQueueWithoutWaste(int capacity){
        data = (E[]) new Object[capacity];
        size = 0;
        front = 0;
        tail = 0;
    }
    public LoopQueueWithoutWaste(){
        this(10);
    }
    @Override
    public int getSize() {
        return size;
    }

    public int getCapacity(){
        return data.length;
    }
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void enqueue(E e) {
        if(size == getCapacity()){
            int add = size >> 1 == 0 ? 1 : size >> 1;
            resize(size + add);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size ++;
    }

    @Override
    public E dequeue() {
        if(isEmpty()){
            throw new IllegalArgumentException("queue is empty");
        }
        E element = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size --;
        if(size <= (this.getCapacity() >> 1))
            resize(this.getCapacity() >> 1);
        return element;
    }

    @Override
    public E getFront() {
        if(isEmpty()){
            throw new IllegalArgumentException("queue is empty");
        }
        return data[front];
    }

    private void resize(int newCapacity){
        E[] newData = (E[]) new Object[newCapacity];
        for(int i=0; i<size; i++){
            newData[i] = data[(i + front) % data.length];
        }
        data = newData;
        front = 0;
        tail = size % getCapacity();
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Queue: size = %d , capacity = %d , front = %d , tail = %d\n",getSize(),getCapacity(),front,tail));
        sb.append("Queue: front [");
        for(int i=0; i<size; i++){
            sb.append(data[(i + front) % data.length]);
            if((i + front + 1) % data.length != tail)
                sb.append(", ");
        }
        sb.append("] tail");

        return sb.toString();
    }

    public static void main(String[] args){

        LoopQueueWithoutWaste<Integer> queue = new LoopQueueWithoutWaste<>();
        for(int i = 0 ; i < 13 ; i ++){
            queue.enqueue(i);
            System.out.println(queue);

        }

        for(int i = 0 ; i < 12 ; i ++){

            if(i % 2 == 0){
                queue.dequeue();
                System.out.println(queue);
            }
        }

    }
}
