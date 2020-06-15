package com.datastructure.chapter_09_trie;

/**
 * @date : 2019-12-25
 *  208. 实现 Trie (前缀树)
 *  208. Implement Trie (Prefix Tree)
 *  https://leetcode.com/problems/implement-trie-prefix-tree/description/
 *
 *  你可以假设所有的输入都是由小写字母 a-z 构成的。
 * 保证所有输入均为非空字符串
 *  在此基础上优化
 */
public class Trie208_2 {

    private class Node{
        public Node[] next;
        public boolean isWord;
        public Character c;
        public Node(boolean isWord){
            this.next = new Node[26];
            this.isWord = isWord;
        }
        public Node(){
            this(false);
        }
    }

    private Node root;

    /** Initialize your data structure here. */
    public Trie208_2() {
        root = new Node();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        if(word == null)
            return;
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(cur.next[c - 'a'] == null)
                cur.next[c - 'a'] = new Node();
            cur = cur.next[c - 'a'];
        }
        if(!cur.isWord){
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
            if(cur.next[c - 'a'] == null)
                return false;
            cur = cur.next[c - 'a'];
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
            if(cur.next[c - 'a'] == null)
                return false;
            cur = cur.next[c - 'a'];
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

