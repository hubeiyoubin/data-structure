package com.datastructure.chapter_06_set_map;

import com.datastructure.chapter_05_binary_search_tree.BSTree;

/**
 * @date : 2019-12-18
 */
public class BSTreeSet<E extends Comparable<E>> implements Set<E> {

    private BSTree<E> bsTree;
    public BSTreeSet(){
        bsTree = new BSTree<>();
    }

    @Override
    public boolean isEmpty() {
        return bsTree.isEmpty();
    }

    @Override
    public int size() {
        return bsTree.size();
    }

    @Override
    public boolean contains(E e) {
        return bsTree.contains(e);
    }

    @Override
    public void add(E e) {
        bsTree.add(e);
    }
    @Override
    public void remove(E e) {
        bsTree.remove(e);
    }
}
