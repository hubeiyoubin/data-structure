package com.datastructure.chapter_08_segmentTree;


import org.junit.Test;

/**
 * @date : 2019-12-24
 */
public class SegmentTreeTest {

    @Test
    public void testSegmentTreeBuild(){
        Integer[] nums = {-2, 0, 3, -5, 2, -1};
        SegmentTree<Integer> segmentTree = new SegmentTree(nums,
                new Merger<Integer>() {
                    @Override
                    public Integer merge(Integer a, Integer b) {
                        return a + b;
                    }
                });

        SegmentTree<Integer> segmentTree2 = new SegmentTree<>(nums,
                (a , b) -> a + b);

        System.out.println(segmentTree);
        System.out.println(segmentTree2);

        System.out.println(segmentTree2.query(0, 2));
        System.out.println(segmentTree2.query(2, 5));
        System.out.println(segmentTree2.query(0, 5));
    }

    @Test
    public void testNumArrayComlete_303(){
        int[] nums = {-2, 0, 3, -5, 2, -1};
        NumArrayComplete_303 nc = new NumArrayComplete_303(nums);
        System.out.println(nc.sumRange(0, 2));
        nc.update(0,2);
        System.out.println(nc.sumRange(0, 2));
        System.out.println(nc.sumRange(2, 5));
        System.out.println(nc.sumRange(0, 5));
    }
}
