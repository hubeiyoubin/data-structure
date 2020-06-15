package com.datastructure.chapter_09_trie;

import java.util.ArrayList;
import java.util.Random;
import java.util.TreeMap;

/**
 * @date : 2019-12-27
 */
public class RandomizedSet_TrieR {

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
            add(root, word, val, 0);
        }

        private void add(Node node, String word, int val, int index) {
            if(word.length() == index){
                if(!node.isWord){
                    size ++;
                    node.isWord = true;
                }
                node.val = val;
                return;
            }

            char c = word.charAt(index);
            if(node.next.get(c) == null)
                node.next.put(c, new Node());
            add(node.next.get(c), word, val, index + 1);
        }
        public boolean contains(String word){
            return contains(root, word, 0);
        }

        private boolean contains(Node node, String word, int index) {
            if(word.length() == index){
                return node.isWord;
            }
            char c = word.charAt(index);
            if(node.next.get(c) == null)
                return false;
            return contains(node.next.get(c), word, index + 1);
        }

        // 查询单词word所对应的值
        public int get(String word){
            return get(root, word, 0);
        }

        private int get(Node node, String word, int index) {
            if(word.length() == index)
                return node.val;

            char c = word.charAt(index);
            if(node.next.get(c) == null)
                throw new RuntimeException("word is not exist");
            return get(node.next.get(c), word, index + 1);
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
                return true;
            }
            char c = word.charAt(index);
            if(node.next.get(c) == null)
                return false;
            boolean res = remove(node.next.get(c), word, index + 1);
            Node nextNode = node.next.get(c);
            if(!nextNode.isWord && nextNode.next.size() == 0)
                node.next.remove(c);
            return res;
        }
    }


    private TrieMap trieMap;
    private ArrayList<Integer> list;
    /** Initialize your data structure here. */
    public RandomizedSet_TrieR(){
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

