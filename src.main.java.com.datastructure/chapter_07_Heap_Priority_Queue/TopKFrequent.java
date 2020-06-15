package com.datastructure.chapter_07_Heap_Priority_Queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

/**
 * @date : 2019-12-21
 *
 * 347. Top K Frequent Elements
 *  https://leetcode.com/problems/top-k-frequent-elements/description/
 */
public class TopKFrequent {

    private class Freq implements Comparable<Freq>{

        public int e, freq;

        public Freq(int e, int freq){
            this.e = e;
            this.freq = freq;
        }

        @Override
        public int compareTo(Freq another){
            if(this.freq < another.freq)
                return 1;
            else if(this.freq > another.freq)
                return -1;
            else
                return 0;
        }
    }

    public List<Integer> topKFrequent_01(int[] nums, int k) {

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int num: nums){
            if(map.containsKey(num))
                map.put(num, map.get(num) + 1);
            else
                map.put(num, 1);
        }

        MaxHeap<Freq> maxHeap = new MaxHeap<>();
        for(int key: map.keySet()){
            if(maxHeap.size() < k)
                maxHeap.add(new Freq(key, map.get(key)));
            else if(map.get(key) > maxHeap.findMax().freq){
                maxHeap.extractMax();
                maxHeap.add(new Freq(key, map.get(key)));
            }
        }

        LinkedList<Integer> res = new LinkedList<>();
        while(!maxHeap.isEmpty())
            res.add(maxHeap.extractMax().e);
        return res;
    }

    private static void printList(List<Integer> nums){
        for(Integer num: nums)
            System.out.print(num + " ");
        System.out.println();
    }

    public List<Integer> topKFrequent_02(int[] nums, int k){
        TreeMap<Integer,Integer> treeMap = new TreeMap<>();
        for(int i = 0; i < nums.length; i ++){
            if(!treeMap.containsKey(nums[i])){
                treeMap.put(nums[i],1);
            }else{
                treeMap.put(nums[i],treeMap.get(nums[i]) + 1);
            }
        }
        PriorityQueue<Freq> pq = new PriorityQueue();
        for(int key : treeMap.keySet()){
            if(pq.getSize() < k){
                pq.enqueue(new Freq(key,treeMap.get(key)));
            }else if (treeMap.get(key) > pq.getFront().freq){
                pq.dequeue();
                pq.enqueue(new Freq(key,treeMap.get(key)));
            }
        }
        List<Integer> res = new ArrayList<>(k);
        while(!pq.isEmpty()){
            res.add(pq.dequeue().e);
        }
        return res;
    }
    public static void main(String[] args) {

        int[] nums = {1, 1, 1, 2, 2, 3,3,3,3};
        int k = 2;
        printList((new TopKFrequent()).topKFrequent_01(nums, k));
        printList((new TopKFrequent()).topKFrequent_02(nums, k));
    }
}
