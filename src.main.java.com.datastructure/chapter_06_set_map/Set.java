package com.datastructure.chapter_06_set_map;

/**
 * @date : 2019-12-18
 */
public interface Set<E> {

    boolean isEmpty();
    int size();
    boolean contains(E e);
    void add(E e);
    void remove(E e);
}
