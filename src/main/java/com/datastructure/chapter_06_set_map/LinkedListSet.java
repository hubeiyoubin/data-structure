package com.datastructure.chapter_06_set_map;

import com.datastructure.chapter_03_LinkedList.LinkedList;

/**
 * @date : 2019-12-18
 */
public class LinkedListSet<E> implements Set<E> {
    private LinkedList<E> linkedList;
    public LinkedListSet(){
        linkedList = new LinkedList<>();
    }
    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    @Override
    public int size() {
        return linkedList.getSize();
    }

    @Override
    public boolean contains(E e) {
        return linkedList.contains(e);
    }

    @Override
    public void add(E e) {
        if(!linkedList.contains(e))
            linkedList.addFirst(e);
    }

    @Override
    public void remove(E e) {
        linkedList.removeElement(e);
    }
}
