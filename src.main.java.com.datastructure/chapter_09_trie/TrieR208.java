package com.datastructure.chapter_09_trie;

import java.util.TreeMap;

/**
 * @date : 2019-12-26
 */
public class TrieR208 {

    public class Node{
        public TreeMap<Character,Node> next;
        public boolean isWord;
        public Node(boolean isWord){
            next = new TreeMap<>();
            this.isWord = isWord;
        }
        public Node(){
            this(false);
        }
    }
    private Node root;

    /** Initialize your data structure here. */
    public TrieR208() {
        root = new Node();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        if(word == null)
            return;
        insert(root, word, 0);
    }

    private void insert(Node node, String word, int index) {
        if(word.length() == index){
            if(!node.isWord)
                node.isWord = true;
            return;
        }
        char c = word.charAt(index);
        if(node.next.get(c) == null)
            node.next.put(c , new Node());
        insert(node.next.get(c), word, index + 1);
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if(word == null)
            return false;
        return search(root, word, 0);
    }

    private boolean search(Node node, String word, int index) {
        if(word.length() == index)
            return node.isWord;
        char c = word.charAt(index);
        if(node.next.get(c) == null)
            return false;

        return search(node.next.get(c), word, index + 1);
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        if(prefix == null)
            return false;

        return startsWith(root, prefix, 0);
    }

    private boolean startsWith(Node node, String prefix, int index) {
        if(prefix.length() == index)
            return true;
        char c = prefix.charAt(index);
        if(node.next.get(c) == null)
            return false;
        return startsWith(node.next.get(c), prefix, index + 1);
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */

