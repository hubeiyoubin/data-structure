package com.datastructure.chapter_06_set_map;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @date : 2019-12-19
 */
public class TestCollections {

    @Test
    public void testLinkedListMap(){
        System.out.println("Pride and Prejudice");
        ArrayList<String> words = new ArrayList<>();
        if(FileOperation.readFile(FilePath.pride_and_prejudice, words)) {
            System.out.println("Total words: " + words.size());

            LinkedListMap<String, Integer> map = new LinkedListMap<>();
            for (String word : words) {
                if (map.contains(word))
                    map.set(word, map.get(word) + 1);
                else
                    map.add(word, 1);
            }

            System.out.println("Total different words: " + map.getSize());
            System.out.println("Frequency of PRIDE: " + map.get("pride"));
            System.out.println("Frequency of PREJUDICE: " + map.get("prejudice"));
        }

        System.out.println();
    }

    @Test
    public void testBSTreeMap(){
        System.out.println("Pride and Prejudice");

        ArrayList<String> words = new ArrayList<>();
        if(FileOperation.readFile(FilePath.pride_and_prejudice, words)) {
            System.out.println("Total words: " + words.size());

            BSTreeMap<String, Integer> map = new BSTreeMap<>();
            for (String word : words) {
                if (map.contains(word))
                    map.set(word, map.get(word) + 1);
                else
                    map.add(word, 1);
            }

            System.out.println("Total different words: " + map.getSize());
            System.out.println("Frequency of PRIDE: " + map.get("pride"));
            System.out.println("Frequency of PREJUDICE: " + map.get("prejudice"));
        }

        System.out.println();
    }

    public int[] intersect(int[] nums1, int[] nums2) {

        BSTreeMap<Integer, Integer> map = new BSTreeMap<>();
        for(int num: nums1){
            if(!map.contains(num))
                map.add(num, 1);
            else
                map.set(num, map.get(num) + 1);
        }

        ArrayList<Integer> res = new ArrayList<>();
        for(int num: nums2){
            if(map.contains(num)){
                res.add(num);
                map.set(num, map.get(num) - 1);
                if(map.get(num) == 0)
                    map.remove(num);
            }
        }

        int[] ret = new int[res.size()];
        for(int i = 0 ; i < res.size() ; i ++)
            ret[i] = res.get(i);

        return ret;
    }

    public int[] intersection(int[] nums1, int[] nums2) {

        BSTreeSet<Integer> set = new BSTreeSet<>();
        for(int num: nums1)
            set.add(num);

        ArrayList<Integer> list = new ArrayList<>();
        for(int num: nums2){
            if(set.contains(num)){
                list.add(num);
                set.remove(num);
            }
        }

        int[] res = new int[list.size()];
        for(int i = 0 ; i < list.size() ; i ++)
            res[i] = list.get(i);
        return res;
    }

    public static void main(String[] args) {
       TestCollections tc = new TestCollections();
       /*  long start = System.nanoTime();
        tc.testLinkedListMap();
        long middle = System.nanoTime();
        tc.testBSTreeMap();
        long end = System.nanoTime();
        System.out.println("testLinkedListMap: "+(middle - start) / 1000_000_000.0);
        System.out.println("testBSTreeMap: "+(end - middle) / 1000_000_000.0);*/
         int[] num1 = {1,2,2,2,2,3,4,5,6,7};
         int[] num2 = {1,2,2,2,2,30,40};
         int[] res = tc.intersect(num1,num2);
        System.out.println(Arrays.toString(res));
        int[] res2 = tc.intersection(num1,num2);
        System.out.println(Arrays.toString(res2));
    }
}
