package com.datastructure.chapter_08_segmentTree;

/**
 * @date : 2019-12-24
 * /// 303. Range Sum Query - Immutable
 * /// https://leetcode.com/problems/range-sum-query-immutable/description/
 */
public class NumArrayComplete_303 {
    private interface Merger<E>{
        E merge(E a, E b);
    }

    private class SegmentTree<E> {
        private E[] data;
        private E[] tree;
        private Merger<E> merger;

        public SegmentTree(E[] arr, Merger<E> merger){
            this.merger = merger;
            data = (E [])new Object[arr.length];
            for (int i = 0; i < arr.length; i++) {
                data[i] = arr[i];
            }
            tree = (E [])new Object[4 * arr.length];
            this.buildSegmentTree(0, 0, arr.length - 1);
        }

        private void buildSegmentTree(int treeIndex, int l, int r) {
            if(l == r){
                tree[treeIndex] = data[l];
                return;
            }

            int treeLeft = leftChild(treeIndex);
            int treeRight = rightChild(treeIndex);
            int mid = l + (r - l) / 2;
            buildSegmentTree(treeLeft, l, mid);
            buildSegmentTree(treeRight,mid + 1,r);
            tree[treeIndex] = merger.merge(tree[treeLeft], tree[treeRight]);
        }

        private int leftChild(int index){
            return 2 * index + 1;
        }
        private int rightChild(int index){
            return 2 * index + 2;
        }

        public int getSize(){
            return data.length;
        }
        public E get(int index){
            if(0 > index || index > data.length - 1)
                throw new IllegalArgumentException("index is illegal");
            return data[index];
        }
        public E query(int start, int end){
            if(start < 0 || start >= data.length ||
                    end < 0 || end >= data.length )
                throw new IllegalArgumentException("index is illegal");

            return query(0, 0, data.length - 1, start, end);
        }

        private E query(int treeIndex, int l, int r, int start, int end) {
            if(l == start && r == end){
                return tree[treeIndex];
            }
            int treeLeft = this.leftChild(treeIndex);
            int treeRight = this.rightChild(treeIndex);
            int mid = l + (r - l) / 2;
            if(end <= mid){
                return query(treeLeft, l, mid, start, end);
            }else if(start > mid){
                return query(treeRight, mid + 1, r, start, end);
            }
            E leftRes = query(treeLeft,l,mid,start,mid);
            E rightRes = query(treeRight,mid + 1, r,mid + 1,end);
            return merger.merge(leftRes,rightRes);
        }

        // 将index位置的值，更新为e
        public void set(int index, E e){
            if(index < 0 || index >= data.length)
                throw new IllegalArgumentException("index is illegal");
            data[index] = e;
            set(0, 0, data.length - 1, index, e);
        }

        private void set(int treeIndex, int l, int r, int index, E e) {
            if(l == r){
                tree[treeIndex] = e;
                return;
            }
            int mid = l + (r - l) / 2;
            int treeLeft = this.leftChild(treeIndex);
            int treeRight = this.rightChild(treeIndex);
            if(index <= mid){
                set(treeLeft, l, mid, index, e);
            }else{
                set(treeRight,mid + 1, r, index, e);
            }
            tree[treeIndex] = merger.merge(tree[treeLeft], tree[treeRight]);
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
                    res.append(", ");
            }
            res.append(" ]");
            return res.toString();
        }
    }

    private SegmentTree<Integer> segmentTree;

    public NumArrayComplete_303(int[] nums){
        if(nums.length != 0){
            Integer[] data = new Integer[nums.length];
            for (int i = 0; i < nums.length; i++) {
                data[i] = nums[i];
            }
            segmentTree = new SegmentTree<>(data, (a,b) -> a + b);
        }
    }
    //update
    public void update(int i, int val){
        if(segmentTree == null)
            throw new IllegalArgumentException("segmentTree is null");
        segmentTree.set(i, val);
    }
    //sumRange
    public int sumRange(int i, int j){
        if(segmentTree == null)
            throw new IllegalArgumentException("segmentTree is null");
        return segmentTree.query(i, j);
    }



}
