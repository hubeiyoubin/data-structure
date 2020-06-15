package com.datastructure.chapter_10_union_find;



/**
 * @date : 2019-12-31
 * 第四版， 进行高度排序优化
 */
public class UnionFind4 implements UF{

    private int[] parent;
    private int[] rank;

    public UnionFind4(int size){
        parent = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
            rank[i] = 1;
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

    private int find(int p){
        if(p < 0 || p >= parent.length)
            throw new IllegalArgumentException("p is out of bound");
        /*while(p != parent[p])
            p = parent[p];*/

        if(p == parent[p])
            return p;

        return find(parent[p]);
    }
    @Override
    public void unionElements(int p, int q) {

        int pRoot = parent[p];
        int qRoot = parent[q];
        if(pRoot == qRoot)
            return;

        if(rank[pRoot] > rank[qRoot]){
            parent[qRoot] = pRoot;
        }else if(rank[pRoot] < rank[qRoot]){
            parent[pRoot] = qRoot;
        }else{
            parent[pRoot] = qRoot;
            rank[qRoot] += 1;
        }
    }
}
