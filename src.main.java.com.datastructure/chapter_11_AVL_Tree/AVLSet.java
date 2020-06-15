package com.datastructure.chapter_11_AVL_Tree;

import com.datastructure.chapter_06_set_map.Set;

/**
 * @date : 2020-1-2
 */
public class AVLSet<E extends Comparable<E>> implements Set<E> {

    AVLTree<E, Object> avl;

    public AVLSet(){
        avl = new AVLTree();
    }
    @Override
    public void add(E e) {
        avl.add(e, null);
    }

    @Override
    public boolean contains(E e) {
        return avl.contains(e);
    }

    @Override
    public void remove(E e) {
        avl.remove(e);
    }

    @Override
    public int size() {
        return avl.getSize();
    }

    @Override
    public boolean isEmpty() {
        return avl.isEmpty();
    }
}
