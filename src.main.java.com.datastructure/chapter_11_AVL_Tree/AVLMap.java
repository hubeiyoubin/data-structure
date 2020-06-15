package com.datastructure.chapter_11_AVL_Tree;

import com.datastructure.chapter_06_set_map.Map;

/**
 * @date : 2020-1-2
 */
public class AVLMap<K extends Comparable<K>, V>  implements Map<K,V> {

    private AVLTree<K, V> avl;
    public AVLMap(){
        avl = new AVLTree();
    }

    @Override
    public void add(K key, V value) {
        avl.add(key, value);
    }

    @Override
    public boolean contains(K key) {
        return avl.contains(key);
    }

    @Override
    public V get(K key) {
        return avl.get(key);
    }

    @Override
    public void set(K key, V newValue) {
        avl.set(key,newValue);
    }

    @Override
    public V remove(K key) {
        return avl.remove(key);
    }

    @Override
    public int getSize() {
        return avl.getSize();
    }

    @Override
    public boolean isEmpty() {
        return avl.isEmpty();
    }
}
