package com.datastructure.chapter_09_trie;

import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;
import java.util.TreeMap;

/**
 * @date : 2019-12-27
 * Leetcode 380. Insert Delete GetRandom O(1)
 */
public class RandomizedSet_Trie {

    private class TrieMap{

        private class Node{
            public boolean isWord;
            public TreeMap<Character, Node> next;
            public int val;
            public Node(boolean isWord, int val){
                this.next = new TreeMap<>();
                this.isWord = isWord;
                this.val = val;
            }

            public Node(){
                this(false, - 1);
            }
        }

        private Node root;
        private int size;

        public TrieMap(){
            root = new Node();
            size = 0;
        }
        public int getSize(){
            return size;
        }

        public void add(String word, int val){
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
            cur.val = val;
        }

        public boolean contains(String word){
            Node cur = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if(cur.next.get(c) == null)
                    return false;
                cur = cur.next.get(c);
            }
            return cur.isWord;
        }

        // 查询单词word所对应的值
        public int get(String word){
            Node cur = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if(cur.next.get(c) == null)
                    throw new RuntimeException("val is not exist");
                cur = cur.next.get(c);
            }
            return cur.val;
        }

        public boolean remove(String word){
            Stack<Node> stack = new Stack<>();
            stack.push(root);
            for (int i = 0; i < word.length(); i++) {
                char c =word.charAt(i);
                if(stack.peek().next.get(c) == null)
                    return false;
                stack.push(stack.peek().next.get(c));
            }

            if(!stack.peek().isWord)
                return false;

            stack.peek().isWord = false;
            size --;

            // 如果单词最后一个字母的节点的next非空，
            // 说明trie中还存储了其他以该单词为前缀的单词，直接返回
            if(stack.peek().next.size() > 0)
                return true;
            else
                stack.pop();

            for (int i = word.length() - 1; i >= 0; i--) {
                stack.peek().next.remove(word.charAt(i));
                if(stack.peek().isWord || stack.peek().next.size() > 0)
                    return true;
            }
            return true;
        }
    }

    private TrieMap trieMap;
    private ArrayList<Integer> list;
    /** Initialize your data structure here. */
    public RandomizedSet_Trie(){
        trieMap = new TrieMap();
        list = new ArrayList();
    }


    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        String key = String.valueOf(val);
        if(trieMap.contains(key))
            return false;

        list.add(val);
        int index = list.size() - 1;
        trieMap.add(key, index);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        String key = String.valueOf(val);
        if(!trieMap.contains(key))
            return false;

        int index = trieMap.get(key);
        trieMap.remove(key);

        int num = list.get(list.size() - 1);
        list.remove(list.size() - 1);

        if(num != val){
            list.set(index, num);
            trieMap.add(String.valueOf(num), index);
        }
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        Random rs = new Random();
        int index = rs.nextInt(list.size());
        return list.get(index);
    }

}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */

