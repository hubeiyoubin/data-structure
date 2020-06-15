package com.datastructure.chapter_10_union_find;

/**
 * @date : 2019-12-31
 * 第二版， 构建一棵树
 * 使用一个数组构建一棵指向父节点的树
 */
public class UnionFind2 implements UF {

    private int[] parent;

    public UnionFind2(int size){
        parent = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
        }
    }
    @Override
    public int getSize() {
        return parent.length;
    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    private int find(int element){
        if(element < 0 || element >= parent.length){
            throw new IllegalArgumentException("element is out of bound");
        }
        while(element != parent[element]){
            element = parent[element];
        }
        return parent[element];
    }
    @Override
    public void unionElements(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if(pRoot == qRoot)
            return;

        parent[q] = pRoot;
    }
}
