package com.datastructure.chapter_02_stack_queue;

/**
 * @date : 2019-10-30
 */
public class LoopQueue<E> implements Queue<E> {
    private int front,tail;
    private int size;
    private E[] data;

    public LoopQueue(int capacity){
        data = (E[]) new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }
    public LoopQueue(){
        this(10);
    }
    @Override
    public int getSize() {
        return size;
    }

    public int getCapacity(){
        return data.length - 1;
    }
    @Override
    public boolean isEmpty() {
        return  tail == front;
        //size == 0
    }

    @Override
    public void enqueue(E e) {
        if((tail + 1) % data.length == front){
            int add = size >> 1 == 0 ? 1 : size >> 1;
            this.resize(size + add);
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
        E res = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size --;
        if(size <= (getCapacity() >> 1))
            resize(getCapacity() >> 1);
        return res;
    }

    @Override
    public E getFront() {
        if(isEmpty()){
            throw new IllegalArgumentException("queue is empty");
        }
        return data[front];
    }

    public void resize(int newCapacity){
        E[] newData = (E[])new Object[newCapacity + 1];
        for(int i = 0; i < size; i++){
            newData[i] = data[(i + front) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public String toString(){

        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue: size = %d , capacity = %d\n", size, getCapacity()));
        res.append("Queue: front [");
        for(int i = front ; i != tail ; i = (i + 1) % data.length){
            res.append(data[i]);
            if((i + 1) % data.length != tail)
                res.append(", ");
        }
        res.append("] tail");
        return res.toString();
    }
    public static void main(String[] args){

        LoopQueue<Integer> queue = new LoopQueue<>();
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
