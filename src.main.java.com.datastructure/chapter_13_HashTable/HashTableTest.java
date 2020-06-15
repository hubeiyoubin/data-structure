package com.datastructure.chapter_13_HashTable;

import com.datastructure.chapter_06_set_map.BSTreeMap;
import com.datastructure.chapter_06_set_map.FileOperation;
import com.datastructure.chapter_06_set_map.FilePath;
import com.datastructure.chapter_11_AVL_Tree.AVLTree;
import com.datastructure.chapter_12_Red_Black_Tree.RBTree;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @date : 2020-1-6
 */
public class HashTableTest {

    @Test
    public void testHashTable(){
        System.out.println("Pride and Prejudice");

        ArrayList<String> words = new ArrayList<>();
        if(FileOperation.readFile(FilePath.pride_and_prejudice, words)) {
            System.out.println("Total words: " + words.size());

            // Collections.sort(words);

            // Test BST
            long startTime = System.nanoTime();

            BSTreeMap<String, Integer> bst = new BSTreeMap<>();
            for (String word : words) {
                if (bst.contains(word))
                    bst.set(word, bst.get(word) + 1);
                else
                    bst.add(word, 1);
            }

            for(String word: words)
                bst.contains(word);

            long endTime = System.nanoTime();

            double time = (endTime - startTime) / 1000000000.0;
            System.out.println("BST: " + time + " s");


            // Test AVL
            startTime = System.nanoTime();

            AVLTree<String, Integer> avl = new AVLTree<>();
            for (String word : words) {
                if (avl.contains(word))
                    avl.set(word, avl.get(word) + 1);
                else
                    avl.add(word, 1);
            }

            for(String word: words)
                avl.contains(word);

            endTime = System.nanoTime();

            time = (endTime - startTime) / 1000000000.0;
            System.out.println("AVL: " + time + " s");


            // Test RBTree
            startTime = System.nanoTime();

            RBTree<String, Integer> rbt = new RBTree<>();
            for (String word : words) {
                if (rbt.contains(word))
                    rbt.set(word, rbt.get(word) + 1);
                else
                    rbt.add(word, 1);
            }

            for(String word: words)
                rbt.contains(word);

            endTime = System.nanoTime();

            time = (endTime - startTime) / 1000000000.0;
            System.out.println("RBTree: " + time + " s");


            // Test HashTable
            startTime = System.nanoTime();

            HashTable<String, Integer> ht = new HashTable<>();
            //HashTable<String, Integer> ht = new HashTable<>(131071);
            for (String word : words) {
                if (ht.contains(word))
                    ht.set(word, ht.get(word) + 1);
                else
                    ht.add(word, 1);
            }

            for(String word: words)
                ht.contains(word);

            endTime = System.nanoTime();

            time = (endTime - startTime) / 1000000000.0;
            System.out.println("HashTable: " + ht.getSize());
            System.out.println("HashTable: " + time + " s");
        }

        System.out.println();
    }



    public int[] intersect(int[] nums1, int[] nums2) {

        HashTable<Integer, Integer> map = new HashTable<>();
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

    @Test
    public void testSolution(){
        HashTableTest ht = new HashTableTest();
        int[] nums1 = {1,2,3,3,3,3};
        int[] nums2 = {4,5,3,3,3,1};
        int[] nums = ht.intersect(nums1, nums2);
        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        HashTableTest ht = new HashTableTest();
        int[] nums1 = {1,2,3,3,3,3};
        int[] nums2 = {4,5,3,3,3,1};
        int[] nums = ht.intersect(nums1, nums2);
        System.out.println(Arrays.toString(nums));
    }
}
