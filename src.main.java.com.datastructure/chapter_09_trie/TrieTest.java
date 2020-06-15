package com.datastructure.chapter_09_trie;

import com.datastructure.chapter_05_binary_search_tree.BSTree;
import com.datastructure.chapter_06_set_map.BSTreeSet;
import com.datastructure.chapter_06_set_map.FileOperation;
import com.datastructure.chapter_06_set_map.FilePath;
import org.junit.Test;

import java.util.ArrayList;

/**
 * @date : 2019-12-25
 */
public class TrieTest {

    @Test
    public void trieAndBSTreeTest(){
        System.out.println("Pride and Prejudice");

        ArrayList<String> words = new ArrayList<>();

        if(FileOperation.readFile(FilePath.pride_and_prejudice,words)
                && FileOperation.readFile(FilePath.a_tale_of_two_cities,words)){
            BSTree bsTree = new BSTree();
            long start = System.nanoTime();
            for(String word: words)
                bsTree.add(word);

            for(String word: words)
                bsTree.contains(word);

            long end = System.nanoTime();
            double time = (end - start) / 1000_000_000.0;
            System.out.println("BSTree size :" + bsTree.size());
            System.out.println("Time :" + time + "s");

            Trie trie = new Trie();
            start = System.nanoTime();
            for(String word: words)
                trie.add(word);

            for(String word: words)
                trie.contains(word);

            end = System.nanoTime();
            time = (end - start) / 1000_000_000.0;
            System.out.println("Trie size :"+ trie.getSize());
            System.out.println("Time :" + time + "s");
        }
    }


    @Test
    public void trieTimeTest(){
        System.out.println("Pride and Prejudice");

        ArrayList<String> words = new ArrayList<>();

        if(FileOperation.readFile(FilePath.pride_and_prejudice,words)
                && FileOperation.readFile(FilePath.a_tale_of_two_cities,words)){

            // Test BST
            long startTime = System.nanoTime();

            BSTreeSet<String> set = new BSTreeSet<>();
            for(String word: words)
                set.add(word);

            for(String word: words)
                set.contains(word);

            long endTime = System.nanoTime();

            double time = (endTime - startTime) / 1000000000.0;

            System.out.println("Total different words: " + set.size());
            System.out.println("BSTSet: " + time + " s");

            // ---

            // Test TreeMap Trie
            startTime = System.nanoTime();

            Trie trie = new Trie();
            for(String word: words)
                trie.add(word);

            for(String word: words)
                trie.contains(word);

            endTime = System.nanoTime();

            time = (endTime - startTime) / 1000000000.0;

            System.out.println("Total different words: " + trie.getSize());
            System.out.println("TreeMap Trie: " + time + " s");

            // ---

            // Test HashMap Trie
            startTime = System.nanoTime();

            Trie2 trie2 = new Trie2();
            for(String word: words)
                trie2.add(word);

            for(String word: words)
                trie2.contains(word);

            endTime = System.nanoTime();

            time = (endTime - startTime) / 1000000000.0;

            System.out.println("Total different words: " + trie2.getSize());
            System.out.println("HashMap Trie: " + time + " s");

            // ---

            // Test Array(Map) Trie
            startTime = System.nanoTime();

            Trie3 trie3 = new Trie3();
            for(String word: words)
                trie3.add(word);

            for(String word: words)
                trie3.contains(word);

            endTime = System.nanoTime();

            time = (endTime - startTime) / 1000000000.0;

            System.out.println("Total different words: " + trie3.getSize());
            System.out.println("Array(Map) Trie: " + time + " s");
        }

    }

    @Test
    public void testTrieR208(){
        TrieR208  tr = new TrieR208();
        tr.insert("abc");
        System.out.println(tr.search("abc"));
        System.out.println(tr.startsWith("ab"));
    }

    public static void main(String[] args) {
       char[] c = new char[10];
       int b = 'A' - 'a';
       System.out.println(b);
    }


}
