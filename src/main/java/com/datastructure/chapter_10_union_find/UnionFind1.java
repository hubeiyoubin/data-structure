package com.datastructure.chapter_10_union_find;

/**
 * @date : 2019-12-31
 * 第一版 本质就是一个数组
 */
public class UnionFind1 implements UF{

    private int[] ids;
    public UnionFind1(int size){
        ids = new int[size];

        // 初始化, 每一个ids[i]指向自己, 没有合并的元素
        for (int i = 0; i < size; i++) {
            ids[i] = i;
        }
    }

    @Override
    public int getSize() {
        return ids.length;
    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    public int find(int element){
        if(element < 0 || element >= ids.length)
            throw new IllegalArgumentException("element is not exist");
        return ids[element];
    }
    @Override
    public void unionElements(int p, int q) {
        int pId = find(p);
        int qId = find(q);

        if(pId == qId)
            return;

        for (int i = 0; i < ids.length; i++) {
            if(ids[i] == pId)
                ids[i] = qId;
        }

    }
}
