package com.datastructure.chapter_08_segmentTree;

/**
 * @date : 2019-12-24
 *  303. Range Sum Query - Immutable
 *  https://leetcode.com/problems/range-sum-query-immutable/description/
 */
public class NumArray02 {
    //数组解答
    // sum[i]存储前i个元素和, sum[0] = 0
    // 即sum[i]存储nums[0...i-1]的和
    // sum(i, j) = sum[j + 1] - sum[i]
    private int[] sum;
    public NumArray02(int[] nums) {
        sum = new int[nums.length + 1];
        sum[0] = 0;
        for (int i = 1; i < sum.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
    }

    public int sumRange(int i, int j) {
        return sum[j + 1] - sum[i];
    }
}
