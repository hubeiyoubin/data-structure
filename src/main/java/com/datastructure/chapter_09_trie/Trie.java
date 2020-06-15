package com.datastructure.chapter_09_trie;


import java.util.Stack;
import java.util.TreeMap;

/**
 * @date : 2019-12-25
 * 使用treeMap实现trie
 */
public class Trie {
    private class Node{

        public boolean isWord;
        public TreeMap<Character,Node> next;

        public Node(TreeMap<Character,Node> next, boolean isWord) {
            this.next = next;
            this.isWord = isWord;
        }

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

    public Trie(){
        root = new Node();
        size = 0;
    }
    // 获得Trie中存储的单词数量
    public int getSize(){
        return size;
    }

    // 向Trie中添加一个新的单词word
    public void add(String word){
        if(word == null)
            throw new IllegalArgumentException("param is null");
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(!cur.next.containsKey(c)){
                cur.next.put(c, new Node());
            }
            cur = cur.next.get(c);
        }
        if(!cur.isWord) {
            cur.isWord = true;
            size ++;
        }
    }

    // 查询单词word是否在Trie中
    public boolean contains(String word){
        if(word == null)
            throw new IllegalArgumentException("param is null");
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(!cur.next.containsKey(c))
                return false;
            cur = cur.next.get(c);
        }
        return cur.isWord;
    }

    // 查询是否在Trie中有单词以prefix为前缀
    public boolean isPrefix(String prefix){
        if(prefix == null)
            throw new IllegalArgumentException("param is null");
        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if(!cur.next.containsKey(c))
                return false;
            cur = cur.next.get(c);
        }
        return true;
    }

    // 删除word, 返回是否删除成功
    public boolean remove(String word){
        if(word == null)
            return false;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(stack.peek().next.get(c) == null)
                return false;
            stack.push(stack.peek().next.get(c));
        }
        if(!stack.peek().isWord)
            return false;

        stack.peek().isWord = false;
        size --;

        if(stack.peek().next.size() > 0)
            return true;
        else
            stack.pop();
        for (int i = word.length() - 1; i >= 0; i--) {
            char r = word.charAt(i);
            stack.peek().next.remove(r);
            if(stack.peek().isWord || stack.peek().next.size() > 0)
                return true;

            stack.pop();
        }
        return true;
    }
}
