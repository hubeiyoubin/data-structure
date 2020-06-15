package com.datastructure.chapter_09_trie;

import java.util.TreeMap;

/**
 * @date : 2019-12-26
 *  TrieR 是 Trie in Recursion的意思
 *  TrieR将使用递归的方式，实现Trie的基本功能
 */
public class TrieR {

    private class Node{
        public TreeMap<Character,Node> next;
        public boolean isWord;

        public Node(boolean isWord){
            this.isWord = isWord;
            next = new TreeMap<>();
        }
        public Node(){
            this(false);
        }
    }

    private Node root;
    private int size;

    public TrieR(){
        root = new Node();
        size = 0;
    }

    public int getSize(){
        return size;
    }

    public void add(String word){
        if(word == null || word.length() == 0)
            return;
        add(root, word, 0);
    }

    private void add(Node node, String word, int index) {
        if(word.length() == index){
            if(!node.isWord) {
                node.isWord = true;
                size++;
            }
            return;
        }

        char c = word.charAt(index);
        if(node.next.get(c) == null) {
            node.next.put(c, new Node());
        }
        add(node.next.get(c), word, index + 1);
    }

    public boolean contains(String word){
        if(word == null || word.length() == 0)
            return false;
       return contains(root, word, 0);
    }

    private boolean contains(Node node, String word, int index) {
        if(word.length() == index){
            return node.isWord;
        }
        char c = word.charAt(index);
        Node cur = node.next.get(c);
        if(cur == null)
            return false;
        return contains(cur, word, index + 1);
    }

    private boolean isPrefix(String prefix){
        if(prefix == null || prefix.length() == 0)
            return false;
        return isPrefix(root, prefix, 0);
    }

    private boolean isPrefix(Node node, String prefix, int index) {
        if(prefix.length() == index)
            return true;
        char c = prefix.charAt(index);
        if(node.next.get(c) == null)
            return false;
        return isPrefix(node.next.get(c), prefix, index + 1);
    }


    public boolean remove(String word){
        if(word == null || word.length() == 0)
            return false;

        return remove(root, word, 0);
    }

    private boolean remove(Node node, String word, int index) {
        if(word.length() == index){
            if(!node.isWord)
                return false;
            node.isWord = false;
            size --;
        }
        char c = word.charAt(index);
        if(node.next.get(c) == null)
            return false;

        boolean ret = remove(node.next.get(c), word, index + 1);
        Node nextNode = node.next.get(c);
        if(!nextNode.isWord && nextNode.next.size() == 0)
            node.next.remove(word.charAt(index));
        return ret;
    }

    public static void main(String[] args) {
        TrieR tr = new TrieR();
        tr.add("abc");
        System.out.println(tr.getSize());
        boolean a = tr.contains("abc");

        System.out.println(tr.isPrefix("a"));
    }
}
