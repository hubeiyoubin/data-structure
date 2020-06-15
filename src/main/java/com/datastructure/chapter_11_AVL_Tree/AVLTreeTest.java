package com.datastructure.chapter_11_AVL_Tree;

import com.datastructure.chapter_06_set_map.BSTreeMap;
import com.datastructure.chapter_06_set_map.FileOperation;
import com.datastructure.chapter_06_set_map.FilePath;
import org.junit.Test;

import java.util.*;

/**
 * @date : 2019-12-31
 */
public class AVLTreeTest {

    @Test
    public void testAVLTree(){
        System.out.println("Pride and Prejudice");

        ArrayList<String> words = new ArrayList<>();
        if(FileOperation.readFile(FilePath.pride_and_prejudice, words)) {
            System.out.println("Total words: " + words.size());

            AVLTree<String, Integer> map = new AVLTree<>();
            for (String word : words) {
                if (map.contains(word))
                    map.set(word, map.get(word) + 1);
                else
                    map.add(word, 1);
            }

            System.out.println("Total different words: " + map.getSize());
            System.out.println("Frequency of PRIDE: " + map.get("pride"));
            System.out.println("Frequency of PREJUDICE: " + map.get("prejudice"));

            System.out.println("is BST : " + map.isBST());
            System.out.println("is Balanced : " + map.isBalanced());

            for(String word: words){
                map.remove(word);
                if(!map.isBST() || !map.isBalanced()) {
                    // throw new RuntimeException();
                    System.out.println("BST remove : " + map.isBST());
                    System.out.println("Balanced remove : " + map.isBalanced());
                    break;
                }
            }
        }

        System.out.println();


    }


    @Test
    public void compareAVLandBST(){
        System.out.println("Pride and Prejudice");

        ArrayList<String> words = new ArrayList<>();
        if(FileOperation.readFile(FilePath.pride_and_prejudice, words)) {
            System.out.println("Total words: " + words.size());

            Collections.sort(words);

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
            System.out.println("Total different words: " + bst.getSize());
            System.out.println("Frequency of PRIDE: " + bst.get("pride"));
            System.out.println("Frequency of PREJUDICE: " + bst.get("prejudice"));
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
            System.out.println("Total different words: " + avl.getSize());
            System.out.println("Frequency of PRIDE: " + avl.get("pride"));
            System.out.println("Frequency of PREJUDICE: " + avl.get("prejudice"));
            System.out.println("AVL: " + time + " s");
        }

        System.out.println();
    }


    public int[] intersection(int[] nums1, int[] nums2) {

        Set<Integer> set = new HashSet<>();
        for(int num: nums1)
            set.add(num);

        Set<Integer> inSet = new HashSet<>();
        for(int num: nums2){
            if(set.contains(num)){
                inSet.add(num);
            }
        }
        int[] res = new int[inSet.size()];
        int i = 0;
        for(int in : inSet){
            if(i < inSet.size())
                res[i] = in;
            i ++;
        }
        return res;
    }

    public int[] intersect(int[] nums1, int[] nums2) {

        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num: nums1){
            if(!map.containsKey(num))
                map.put(num, 1);
            else
                map.put(num, map.get(num) + 1);
        }

        ArrayList<Integer> res = new ArrayList<>();
        for(int num: nums2){
            if(map.containsKey(num) ){
                res.add(num);
                map.put(num, map.get(num) - 1);
                if(map.get(num) == 0)
                    map.remove(num);
            }
        }

        int[] ret = new int[res.size()];
        for(int i = 0 ; i < res.size() ; i ++)
            ret[i] = res.get(i);

        return ret;
    }

}
