package com.datastructure.chapter_06_set_map;

/**
 * @date : 2019-12-19
 */
public class BSTreeMap<K extends  Comparable<K>, V> implements Map<K,V> {

    private class Node{
        Node left;
        Node right;
        K key;
        V value;
        public Node(K key, V value,Node left, Node right){
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }
        public Node(K key, V value){
            this(key,value,null,null);
        }
        public Node(K key){
            this(key, null, null, null);
        }
    }

    private Node root;
    private int size;

    public BSTreeMap(){
        root = null;
        size = 0;
    }
    @Override
    public void add(K key, V value) {
        root = add(root,key,value);
    }

    private Node add(Node node,K key,V value){
        if(node == null){
            size ++;
            return new Node(key, value);
        }
        if(key.compareTo(node.key) < 0){
            node.left = add(node.left, key, value);
        }else if(key.compareTo(node.key) > 0){
            node.right = add(node.right,key,value);
        }else if(key.compareTo(node.key) == 0){
            node.value = value;
        }
        return node;
    }

    @Override
    public boolean contains(K key) {
        return getNode(root,key) != null;
    }

    @Override
    public V get(K key) {
        Node node = getNode(root, key);
        return node == null ? null : node.value;
    }

    // 返回以node为根节点的二分搜索树中，key所在的节点
    private Node getNode(Node node, K key){
        if(node == null)
            return node;
        if(key.compareTo(node.key) < 0){
            return getNode(node.left, key);
        }else if(key.compareTo(node.key) > 0){
            return getNode(node.right, key);
        }else{
            return node;
        }
    }
    @Override
    public void set(K key, V newValue) {
        Node node = getNode(root, key);
        if(node != null)
            node.value = newValue;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    private Node minimum(Node node){
        if(node.left == null)
            return node;
        return minimum(node.left);
    }
    private Node removeMin(Node node){
        if(node.left == null){
            Node nodeRight = node.right;
            node.right = null;
            size --;
            return nodeRight;
        }
        node.left = removeMin(node.left);
        return node;
    }
    @Override
    public V remove(K key) {
        Node node = getNode(root, key);
        if(node == null)
            throw new IllegalArgumentException("key is not exist!");
        root = remove(root,key);
        return node.value;
    }

    private Node remove(Node node, K key) {
        if(node == null)
            return node;
        if(key.compareTo(node.key) > 0){
            node.right = remove(node.right, key);
            return node;
        }else if(key.compareTo(node.key) < 0){
            node.left = remove(node.left, key);
            return node;
        }else{
            if(node.left == null){
                Node nodeRight = node.right;
                node.right = null;
                size --;
                return nodeRight;
            }
            if(node.right == null){
                Node nodeLeft = node.left;
                node.left = null;
                size --;
                return nodeLeft;
            }

            Node mvNode = minimum(node.right);
            mvNode.right = removeMin(node.right);
            mvNode.left = node.left;
            node.left = node.right = null;
            return mvNode;
        }
    }


}
