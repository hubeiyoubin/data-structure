package com.datastructure.chapter_09_trie;

import java.util.TreeMap;

/**
 * @date : 2019-12-25
 *  Leetcode 211. Add and Search Word - Data structure design
 *  https://leetcode.com/problems/add-and-search-word-data-structure-design/description/
 *
 * addWord("bad")
 * addWord("dad")
 * addWord("mad")
 * search("pad") -> false
 * search("bad") -> true
 * search(".ad") -> true
 * search("b..") -> true
 *
 *
 */
public class WordDictionary211 {

    public class Node{
        public boolean isWord;
        TreeMap<Character,Node> next;
        public Node(){
            this.next = new TreeMap<>();
            isWord = false;
        }
    }
    private Node root;
    /** Initialize your data structure here. */
    public WordDictionary211() {
        root = new Node();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        if(word == null)
            return;
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(!cur.next.containsKey(c))
                cur.next.put(c,new Node());
            cur = cur.next.get(c);
        }
        if(!cur.isWord)
            cur.isWord = true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return match(root, word, 0);
    }

    private boolean match(Node node, String word, int index) {
        if(word.length() == index){
            return node.isWord;
        }
        char c = word.charAt(index);
        if(c != '.'){
            if(!node.next.containsKey(c))
                return false;
           return match(node.next.get(c), word, index + 1);
        }else{
            for(char ch : node.next.keySet())
                if(match(node.next.get(ch), word, index + 1))
                    return true;
            return false;
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */

