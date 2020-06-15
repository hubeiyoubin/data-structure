package com.datastructure.chapter_09_trie;

/**
 * @date : 2019-12-26
 * 使用数组实现trie,假设只包含英文小写符号
 */
public class Trie3 {

    private class Node{
        public Node[] next;
        public boolean isWord;

        public Node(boolean isWord){
            this.isWord = isWord;
            next = new Node[137];
        }
        public Node(){
            this(false);
        }

    }

    private Node root;
    private int size;

    public int getSize(){
        return size;
    }
    public Trie3(){
        root = new Node();
        size = 0;
    }

    public void add(String word){
        if(word == null)
            return;
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(c - 'a' > 127){
                System.out.println(c);
            }

            if(cur.next[c - 'a'] == null)
                cur.next[c - 'a'] = new Node();

            cur = cur.next[c - 'a'];
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
            if(cur.next[c - 'a'] == null)
                return false;

            cur = cur.next[c - 'a'];
        }
        return cur.isWord;
    }

    public boolean isPrefix(String prefix){
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
