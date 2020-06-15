package com.datastructure.chapter_07_Heap_Priority_Queue;

import java.util.*;
import java.util.PriorityQueue;

/**
 * @date : 2019-12-21
 *
 * 347. Top K Frequent Elements
 *  https://leetcode.com/problems/top-k-frequent-elements/description/
 */
public class TopKFrequent03 {

    public List<Integer> topKFrequent(int[] nums, int k) {
        TreeMap<Integer,Integer> treeMap = new TreeMap<>();
        for(int i: nums){
            if(!treeMap.containsKey(i)){
                treeMap.put(i, 1);
            }else{
                treeMap.put(i, treeMap.get(i) + 1);
            }
        }

        //表达式三
        PriorityQueue<Integer> pq3 = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return treeMap.get(a) - treeMap.get(b);
            }
        });

        //表达式四
        PriorityQueue<Integer> pq = new PriorityQueue<>(
                (a, b) -> treeMap.get(a) - treeMap.get(b)
        );
        for(int key : treeMap.keySet()){
            if(pq.size() < k){
                pq.add(key);
            }else if (treeMap.get(key) > treeMap.get(pq.peek())){
                pq.remove();
                pq.add(key);
            }
        }
        LinkedList<Integer> res = new LinkedList<>();
        while(!pq.isEmpty())
            res.add(pq.remove());
        return res;
    }

    private static void printList(List<Integer> nums){
        for(Integer num: nums)
            System.out.print(num + " ");
        System.out.println();
    }


    public static void main(String[] args) {

        int[] nums = {1, 1, 1, 2, 2, 3,3,3,3};
        int k = 2;
       printList((new TopKFrequent03()).topKFrequent(nums, k));
       // printList((new TopKFrequent02()).topKFrequent_02(nums, k));
    }
}
