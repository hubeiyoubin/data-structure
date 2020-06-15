package com.datastructure.chapter_09_trie;

import java.util.HashMap;

/**
 * @date : 2019-12-26
 * 使用HashMap实现trie
 */
public class Trie2 {

    private class Node{
        public HashMap<Character,Node> next;
        public boolean isWord;
        public Node(boolean isWord){
            next = new HashMap<>();
            this.isWord = isWord;
        }
        public Node(){
            this(false);
        }
    }

    private Node root;
    private int size;

    public Trie2(){
        root = new Node();
        size = 0;
    }

    public int getSize(){
        return size;
    }
    public void add(String word){
        if(word == null)
            return;

        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(cur.next.get(c) == null)
                cur.next.put(c, new Node());
            cur = cur.next.get(c);
        }
        if(!cur.isWord){
            cur.isWord = true;
            size ++;
        }
    }

    public boolean contains(String word){
        if(word == null)
            return false;
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(cur.next.get(c) == null)
                return false;
            cur = cur.next.get(c);
        }
        return cur.isWord;
    }

    public boolean isPrefix(String prefix){
        if(prefix == null)
            return false;
        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if(cur.next.get(c) == null)
                return false;
            cur = cur.next.get(c);
        }
        return true;
    }
    


}
