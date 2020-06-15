package com.datastructure.chapter_09_trie;

import java.util.TreeMap;

/**
 * @date : 2019-12-26
 * 677. 键值映射
 * 实现一个 MapSum 类里的两个方法，insert 和 sum。
 *
 * 对于方法 insert，你将得到一对（字符串，整数）的键值对。字符串表示键，整数表示值。如果键已经存在，那么原来的键值对将被替代成新的键值对。
 *
 * 对于方法 sum，你将得到一个表示前缀的字符串，你需要返回所有以该前缀开头的键的值的总和。
 *
 */
public class MapSum677 {

    private class Node{
        public int value;
        public TreeMap<Character,Node> next;

        public Node(int value){
            this.value = value;
            next = new TreeMap<>();
        }
        public Node(){
            this(0);
        }
    }

    private Node root;

    /** Initialize your data structure here. */
    public MapSum677() {
        root = new Node();
    }

    public void insert(String key, int val) {
        if(key == null)
            return;

        Node cur = root;
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            if(cur.next.get(c) == null){
                cur.next.put(c, new Node());
            }
            cur = cur.next.get(c);
        }
        cur.value = val;
    }

    public int sum(String prefix) {
        if(prefix == null)
            return 0;

        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if(cur.next.get(c) == null)
                return 0;

            cur = cur.next.get(c);
        }
        return sumValue(cur);
    }

    private int sumValue(Node node) {
        int res = node.value;

        for (char c: node.next.keySet()) {
            res += sumValue(node.next.get(c));
        }
        return res;
    }
//["MapSum", "insert", "sum", "insert", "sum"]
 //       [[], ["aa",3], ["a"], ["aa",2], ["a"]]
    //[null,null,3,null,2]
    public static void main(String[] args) {
        MapSum677 ms = new MapSum677();
        ms.insert("aa",3);
        System.out.println(ms.sum("a"));
        ms.insert("aa",2);
        System.out.println(ms.sum("a"));
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */

