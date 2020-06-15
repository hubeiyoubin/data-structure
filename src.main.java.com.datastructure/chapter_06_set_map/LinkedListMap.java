package com.datastructure.chapter_06_set_map;

/**
 * @date : 2019-12-18
 */
public class LinkedListMap<K,V> implements Map<K,V> {

    private class Node{
        K key;
        V value;
        Node next;
        public Node(K key, V value, Node next){
            this.key = key;
            this.value = value;
            this.next = next;
        }
        public Node(K key,V value){
            this(key,value,null);
        }
        public Node(K key){
            this(key,null,null);
        }
        public Node(){
            this(null,null,null);
        }
        @Override
        public String toString(){
            return key.toString() +" : "+value.toString();
        }
    }

    private Node dummyHead;
    private int size;

    public LinkedListMap(){
        dummyHead = new Node();
        size = 0;
    }
    @Override
    public void add(K key, V value) {
        Node node = getNode(key);
        if(node == null){
            dummyHead.next = new Node(key, value,dummyHead.next);
            size ++;
        }else{
            node.value = value;
        }
    }

    @Override
    public V remove(K key) {
        Node cur = dummyHead;
        while(cur.next != null){
            if(key.equals(cur.next.key)){
                break;
            }
            cur = cur.next;
        }
        if(cur.next != null) {
            Node del = cur.next;
            cur.next = cur.next.next;
            size --;
            del.next = null;
            return del.value;
        }
        return null;
    }

    @Override
    public boolean contains(K key) {
        return getNode(key) != null;
    }

    @Override
    public V get(K key) {
        Node node = getNode(key);
        return node == null ? null : node.value;
    }

    private Node getNode(K key) {
        Node cur = dummyHead.next;
        while(cur != null){
            if(key.equals(cur.key))
                return cur;
            cur = cur.next;
        }
        return null;
    }


    @Override
    public void set(K key, V newValue) {
        Node node = getNode(key);
        if(node != null){
            node.value = newValue;
        }
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }
}
