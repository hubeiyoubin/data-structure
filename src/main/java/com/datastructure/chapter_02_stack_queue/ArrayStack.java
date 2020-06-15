package com.datastructure.chapter_02_stack_queue;

import com.datastructure.chapter_01_array.Array;

/**
 * @date : 2019-10-30
 */
public class ArrayStack<E> implements Stack<E>{

    private Array<E> array;
    public ArrayStack(int capacity){
        array =  new Array<>(capacity);
    }
    public ArrayStack(){
        array = new Array<>();
    }
    @Override
    public int getSize() {
        return array.getSize();
    }

    public int getCapacity(){
        return array.getCapacity();
    }
    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public void push(E e) {
        array.addLast(e);
    }

    @Override
    public E pop() {
        return array.removeLast();
    }

    @Override
    public E peek() {
        return array.getLast();
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Stack: size = %d , capacity = %d\n", array.getSize(), array.getCapacity()));
        sb.append("Stack: ");
        sb.append("[ ");
        for(int i=0 ; i < array.getSize(); i++){
            sb.append(array.get(i));
            if(i != array.getSize()-1)
                sb.append(", ");
        }
        sb.append(" ]");
        sb.append(" top");
        return sb.toString();
    }
}
