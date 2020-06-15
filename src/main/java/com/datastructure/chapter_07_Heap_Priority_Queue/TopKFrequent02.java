package com.datastructure.chapter_07_Heap_Priority_Queue;

import java.util.*;
import java.util.PriorityQueue;

/**
 * @date : 2019-12-21
 *
 * 347. Top K Frequent Elements
 *  https://leetcode.com/problems/top-k-frequent-elements/description/
 */
public class TopKFrequent02 {

    private class Freq{

        public int e, freq;

        public Freq(int e, int freq){
            this.e = e;
            this.freq = freq;
        }
    }
    private class FreqComparator implements Comparator<Freq> {

        @Override
        public int compare(Freq a, Freq b){
            return a.freq - b.freq;
        }
    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        TreeMap<Integer,Integer> treeMap = new TreeMap<>();
        for(int i: nums){
            if(!treeMap.containsKey(i)){
                treeMap.put(i, 1);
            }else{
                treeMap.put(i, treeMap.get(i) + 1);
            }
        }
        // 表达式一
        PriorityQueue<Freq> pq1 = new PriorityQueue<>(new FreqComparator());
        // 表达式二
        PriorityQueue<Freq> pq = new PriorityQueue<>(new Comparator<Freq>(){
            @Override
            public int compare(Freq o1, Freq o2) {
                return o1.freq - o2.freq;
            }
        });
        for(int key : treeMap.keySet()){
            if(pq.size() < k){
                pq.add(new Freq(key, treeMap.get(key)));
            }else if (treeMap.get(key) > pq.peek().freq){
                pq.remove();
                pq.add(new Freq(key, treeMap.get(key)));
            }
        }
        LinkedList<Integer> res = new LinkedList<>();
        while(!pq.isEmpty())
            res.add(pq.remove().e);
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
       printList((new TopKFrequent02()).topKFrequent(nums, k));
       // printList((new TopKFrequent02()).topKFrequent_02(nums, k));
    }
}
