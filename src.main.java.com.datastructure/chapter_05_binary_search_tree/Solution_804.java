package com.datastructure.chapter_05_binary_search_tree;

import org.junit.Test;

/**
 * @date : 2019-12-11
 */
public class Solution_804 {

    public int uniqueMorseRepresentations(String[] words) {

        String[] codes = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        BSTree<String> bsTree = new BSTree<>();
        for(String word: words){
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < word.length(); i ++){
                sb.append(codes[word.charAt(i) - 'a']);
            }
            System.out.println(sb.toString());
            System.out.println(bsTree.contains(sb.toString()));
            if(!bsTree.contains(sb.toString())) {
                bsTree.add(sb.toString());
            }
        }
        System.out.println(bsTree.size());
        System.out.println(bsTree);
        return bsTree.size();
    }

    public static void main(String[] args) {
        Solution_804 solution = new Solution_804();
        String[] array = {"gin", "zen", "gig", "msg"};
        solution.uniqueMorseRepresentations(array);
    }

    @Test
    public void testPrintBSTree(){
        BSTree<Integer> bst = new BSTree<>();
        int[] nums = {5, 3, 6, 8, 4, 2};
        for(int num: nums)
            bst.add(num);

        /////////////////
        //      5      //
        //    /   \    //
        //   3    6    //
        //  / \    \   //
        // 2  4     8  //
        /////////////////
        bst.preOrder();
        System.out.println();

        System.out.println(bst);
    }
}
