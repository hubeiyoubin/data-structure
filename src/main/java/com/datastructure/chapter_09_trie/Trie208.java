package com.datastructure.chapter_09_trie;

import java.util.TreeMap;

/**
 * @date : 2019-12-25
 *  208. 实现 Trie (前缀树)
 *  208. Implement Trie (Prefix Tree)
 *  https://leetcode.com/problems/implement-trie-prefix-tree/description/

 */
public class Trie208 {

    private class Node{
        public TreeMap<Character,Node> next;
        public boolean isWord;
        public Node(boolean isWord){
            this.next = new TreeMap<>();
            this.isWord = isWord;
        }
        public Node(){
            this(false);
        }
    }

    private Node root;
    private int size;

    /** Initialize your data structure here. */
    public Trie208() {
        root = new Node();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        if(word == null)
            return;
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(!cur.next.containsKey(c))
                cur.next.put(c,new Node());
            cur = cur.next.get(c);
        }
        if(!cur.isWord){
            size ++;
            cur.isWord = true;
        }
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if(word == null)
            return false;
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(!cur.next.containsKey(c))
                return false;
            cur = cur.next.get(c);
        }
        return cur.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        if(prefix == null)
            return false;
        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if(!cur.next.containsKey(c))
                return false;
            cur = cur.next.get(c);
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */

