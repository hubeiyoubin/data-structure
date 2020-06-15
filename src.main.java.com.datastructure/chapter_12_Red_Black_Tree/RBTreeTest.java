package com.datastructure.chapter_12_Red_Black_Tree;

import com.datastructure.chapter_06_set_map.FileOperation;
import com.datastructure.chapter_06_set_map.FilePath;
import com.datastructure.chapter_11_AVL_Tree.AVLTree;

import java.util.ArrayList;

/**
 * @date : 2020-1-6
 */
public class RBTreeTest {

    public int uniqueMorseRepresentations(String[] words) {

        String[] codes = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        RBTree<String, Object> set = new RBTree<>();
        for(String word: words){
            StringBuilder res = new StringBuilder();
            for(int i = 0 ; i < word.length() ; i ++)
                res.append(codes[word.charAt(i) - 'a']);

            set.add(res.toString(), null);
        }

        return set.getSize();
    }


    public static void main(String[] args){

        System.out.println("Pride and Prejudice");

        ArrayList<String> words = new ArrayList<>();
        if(FileOperation.readFile(FilePath.pride_and_prejudice, words)) {
            System.out.println("Total words: " + words.size());

            RBTree<String, Integer> map = new RBTree<>();
            for (String word : words) {
                if (map.contains(word))
                    map.set(word, map.get(word) + 1);
                else
                    map.add(word, 1);
            }

            System.out.println("Total different words: " + map.getSize());
            System.out.println("Frequency of PRIDE: " + map.get("pride"));
            System.out.println("Frequency of PREJUDICE: " + map.get("prejudice"));



            AVLTree<String, Integer> avl = new AVLTree<>();
            for (String word : words) {
                if (avl.contains(word))
                    avl.set(word, avl.get(word) + 1);
                else
                    avl.add(word, 1);
            }

            System.out.println("Total different words: " + avl.getSize());
            System.out.println("Frequency of PRIDE: " + avl.get("pride"));
            System.out.println("Frequency of PREJUDICE: " + avl.get("prejudice"));



            RBTree2<String, Integer> map2 = new RBTree2<>();
            for (String word : words) {
                if (map2.contains(word))
                    map2.set(word, map2.get(word) + 1);
                else
                    map2.add(word, 1);
            }

            System.out.println("Total different words: " + map2.getSize());
            System.out.println("Frequency of PRIDE: " + map2.get("pride"));
            System.out.println("Frequency of PREJUDICE: " + map2.get("prejudice"));
        }

        System.out.println();
    }
}
