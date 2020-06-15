package com.datastructure.chapter_08_segmentTree;

/**
 * @date : 2019-12-24
 */
public class SegmentTree<E> {
    private E[] data;
    private E[] tree;
    private Merger<E> merger;

    public SegmentTree(E[] arr,Merger<E> merger){
        data = (E[])new Object[arr.length];
        for (int i = 0; i < arr.length ; i++) {
            data[i] = arr[i];
        }
        tree = (E[]) new Object[4 * arr.length];
        this.merger = merger;
        this.buildSegmentTree(0, 0, data.length - 1);
    }

    public int getSize(){
        return data.length;
    }

    public E get(int index){
        if(index < 0 || index > data.length)
            throw new IllegalArgumentException("index is illegal");
        return data[index];
    }

    // 返回完全二叉树的数组表示中，一个索引所表示的元素的左孩子节点的索引
    private int leftChild(int index){
        return 2 * index + 1;
    }

    // 返回完全二叉树的数组表示中，一个索引所表示的元素的右孩子节点的索引
    private int rightChild(int index){
        return 2 * index + 2;
    }

    // 在treeIndex的位置创建表示区间[l...r]的线段树
    private void buildSegmentTree(int treeIndex, int l, int r){
        if(l == r){
            tree[treeIndex] = data[l];
            return;
        }
        int leftIndex = this.leftChild(treeIndex);
        int rightIndex = this.rightChild(treeIndex);
        int mid = l + (r - l) / 2;
        buildSegmentTree(leftIndex, l, mid);
        buildSegmentTree(rightIndex, mid + 1, r);
        tree[treeIndex] = merger.merge(tree[leftIndex], tree[rightIndex]);
    }

    // 返回区间[queryL, queryR]的值
    public E query(int queryL, int queryR){
        if(queryL < 0 || queryL > data.length || queryR < 0 || queryR > data.length)
            throw new IllegalArgumentException("index is illegal");

        return query(0, 0, data.length - 1, queryL, queryR);
    }

    private E query(int treeIndex, int l, int r, int queryL, int queryR) {
        if(l == queryL && r == queryR)
            return tree[treeIndex];

        int mid = l + (r - l) / 2;
        // [l,mid] [mid + r]
        int leftChild = this.leftChild(treeIndex);
        int rightChild = this.rightChild(treeIndex);
        if(queryL >= mid + 1){
            return query(rightChild, mid + 1, r, queryL, queryR);
        }else if (queryR <= mid){
            return query(leftChild, l, mid, queryL, queryR);
        }
        E left = query(leftChild, l,mid ,queryL, mid);
        E right = query(rightChild,mid+1,r,mid+1,queryR);
        return merger.merge(left,right);
    }

    // 将index位置的值，更新为e
    public void set(int index, E e){

        if(index < 0 || index >= data.length)
            throw new IllegalArgumentException("Index is illegal");

        data[index] = e;
        set(0, 0, data.length - 1, index, e);
    }

    // 在以treeIndex为根的线段树中更新index的值为e
    private void set(int treeIndex, int l, int r, int index, E e) {
        if(l == r){
            tree[treeIndex] = e;
            return;
        }

        int mid = l + (r - l) / 2;
        int leftChild = this.leftChild(treeIndex);
        int rightChild = this.rightChild(treeIndex);

        if(index > mid){
            set(rightChild, mid, r, index ,e);
        }else{
            set(leftChild, l, mid + 1, index, e);
        }

        tree[treeIndex] = merger.merge(tree[leftChild], tree[rightChild]);

    }


    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("[ ");
        for (int i = 0; i < tree.length; i++) {
            if(tree[i] != null)
                res.append(tree[i]);
            else
                res.append("null");

            if(i != tree.length - 1)
                res.append(",");
        }
        res.append(" ]");
        return res.toString();
    }
}
