package com.datastructure.chapter_02_stack_queue;

/**
 * @date : 2019-10-30
 * 在这一版本的实现中，我们完全不使用size，只使用front和tail来完成LoopQueue的所有逻辑：
 */
public class LoopQueueWithoutSize<E> implements Queue<E> {

    private E[] data;
    private int front,tail;

    public LoopQueueWithoutSize(int capacity){
        data = (E[])new Object[capacity + 1];
        front = 0;
        tail = 0;
    }
    public LoopQueueWithoutSize(){
        this(10);
    }
    @Override
    public int getSize() {
        return tail >= front ? tail - front : data.length - (front - tail);
    }

    public int getCapacity(){
        return data.length - 1;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public void enqueue(E e) {
        int size = this.getSize();
        if(size == this.getCapacity()){
            int add = size >> 1 == 0 ? 1 : size >> 1;
            this.resize(size + add);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
    }

    @Override
    public E dequeue() {
        if(isEmpty()){
            throw new IllegalArgumentException("queue is empty");
        }

        E e = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        int size = this.getSize();
        if(size <= (this.getCapacity() >> 1)){
            resize(this.getCapacity() >> 1);
        }
        return e;
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
        for(int i=0; i<this.getSize(); i++){
            newData[i] = data[(front + i) % data.length];
        }
        data = newData;
        tail = getSize();
        front = 0;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Queue: size = %d , capacity = %d\n",getSize(),getCapacity()));
        sb.append("Queue: front [");
        for(int i = 0; i < this.getSize(); i++){
            sb.append(data[(front + i) % data.length]);
            if((front + i + 1) % data.length != tail)
                sb.append(", ");

        }
        sb.append("] tail");
        return sb.toString();
    }


    public static void main(String[] args) {
        LoopQueueWithoutSize<Integer> queue = new LoopQueueWithoutSize();
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
