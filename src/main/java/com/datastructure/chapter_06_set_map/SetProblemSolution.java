package com.datastructure.chapter_06_set_map;

import com.datastructure.chapter_12_Red_Black_Tree.RBTree;

import java.util.TreeSet;

/**
 * @date : 2019-12-18
 */
public class SetProblemSolution {

    public int uniqueMorseRepresentations_TreeSet(String[] words) {
        long start = System.nanoTime();
        String[] codes = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        TreeSet<String> set = new TreeSet<>();
        for(String word : words){
            StringBuilder res = new StringBuilder();
            for(int i = 0 ; i < word.length() ; i ++)
                res.append(codes[word.charAt(i) - 'a']);
            set.add(res.toString());
        }
        long end = System.nanoTime();
        System.out.println("size: " + set.size());
        System.out.println("TreeSet Time: "+  (end - start) / 1000000000.0);
        return set.size();
    }

    public int uniqueMorseRepresentations_BSTreeSet(String[] words) {
        long start = System.nanoTime();
        String[] codes = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        BSTreeSet<String> set = new BSTreeSet<>();
        for(String word : words){
            StringBuilder res = new StringBuilder();
            for(int i = 0 ; i < word.length() ; i ++)
                res.append(codes[word.charAt(i) - 'a']);
            set.add(res.toString());
        }
        long end = System.nanoTime();
        System.out.println("size: " + set.size());
        System.out.println("BSTreeSet Time: "+  (end - start) / 1000000000.0);
        return set.size();
    }

    public int uniqueMorseRepresentations_LinkListSet(String[] words) {
        long start = System.nanoTime();
        String[] codes = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        LinkedListSet<String> set = new LinkedListSet<>();
        for(String word : words){
            StringBuilder res = new StringBuilder();
            for(int i = 0 ; i < word.length() ; i ++)
                res.append(codes[word.charAt(i) - 'a']);
            set.add(res.toString());
        }
        long end = System.nanoTime();
        System.out.println("size: " + set.size());
        System.out.println("LinkedListSet Time: "+  (end - start) / 1000000000.0);
        return set.size();
    }


    public int uniqueMorseRepresentations_RBTree(String[] words) {
        long start = System.nanoTime();
        String[] codes = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        RBTree<String,Object> set = new RBTree<>();
        for(String word : words){
            StringBuilder res = new StringBuilder();
            for(int i = 0 ; i < word.length() ; i ++)
                res.append(codes[word.charAt(i) - 'a']);
            set.add(res.toString(), null);
        }
        long end = System.nanoTime();
        System.out.println("size: " + set.getSize());
        System.out.println("RBTreeSet Time: "+  (end - start) / 1000000000.0);
        return set.getSize();
    }
    public static void main(String[] args) {
        SetProblemSolution sps = new SetProblemSolution();
        String[] array = {"gin", "zen", "gig", "msg","gin", "zen", "gig", "msg","gin", "zen", "gig", "msg",
                "gin", "zen", "gig", "msg","gin", "zen", "gig", "msg","gin", "zen", "gig", "msg",
                "gin", "zen", "gig", "msg","gin", "zen", "gig", "msg","gin", "zen", "gig", "msg",
                "gin", "zen", "gig", "msg","gin", "zen", "gig", "msg","gin", "zen", "gig", "msg",
                "gin", "zen", "gig", "msg","gin", "zen", "gig", "msg","gin", "zen", "gig", "msg",
                "gin", "zen", "gig", "msg","gin", "zen", "gig", "msg","gin", "zen", "gig", "msg"
        };
        sps.uniqueMorseRepresentations_BSTreeSet(array);
        sps.uniqueMorseRepresentations_TreeSet(array);
        sps.uniqueMorseRepresentations_LinkListSet(array);
        sps.uniqueMorseRepresentations_RBTree(array);
    }
}
