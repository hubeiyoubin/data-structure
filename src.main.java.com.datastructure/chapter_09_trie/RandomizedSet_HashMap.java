package com.datastructure.chapter_09_trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * @date : 2019-12-26
 *  Leetcode 380. Insert Delete GetRandom O(1)
 *  https://leetcode.com/problems/insert-delete-getrandom-o1/description/
 */
public class RandomizedSet_HashMap {
    private HashMap<Integer,Integer> map;
    private ArrayList<Integer> nums;

    /** Initialize your data structure here. */
    public RandomizedSet_HashMap() {
        map = new HashMap<>();
        nums = new ArrayList<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.containsKey(val))
            return false;

        nums.add(val);
        int index = nums.size() - 1;
        map.put(val,index);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val))
            return false;

        int index = map.get(val);
        map.remove(val);

        int num = nums.get(nums.size() - 1);
        nums.remove(nums.size() - 1);

        if(num != val) {
            nums.set(index, num);
            map.put(num, index);
        }
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        Random random = new Random();
        int index = random.nextInt(nums.size());
        return nums.get(index);
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("map : [");
        for(int key : map.keySet()){
            sb.append(key);
            sb.append(",");
        }
        sb.append(" ] \n");
        sb.append("arr : [");
        for(int num : nums){
            sb.append(num);
            sb.append(",");
        }
        sb.append(" ]");
        return sb.toString();
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */

