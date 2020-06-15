package com.datastructure.chapter_08_segmentTree;

/**
 * @date : 2019-12-24
 *  303. Range Sum Query - Immutable
 *  https://leetcode.com/problems/range-sum-query-immutable/description/
 */
public class NumArray {

    // 线段树解题
    private SegmentTree<Integer> segmentTree;
    public NumArray(int[] nums) {

      if(nums !=null && nums.length > 0){
          Integer[] data = new Integer[nums.length];
          for (int i = 0; i < nums.length ; i++) {
              data[i] = nums[i];
          }
          segmentTree = new SegmentTree<>(data, (a,b) -> a+b);
      }

    }

    public int sumRange(int i, int j) {
        if(segmentTree == null)
            throw new IllegalArgumentException("segmentTree is null");

        return segmentTree.query(i, j);
    }
}
