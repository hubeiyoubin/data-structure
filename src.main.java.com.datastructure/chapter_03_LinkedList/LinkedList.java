package com.datastructure.chapter_03_LinkedList;

/**
 * @date : 2019-10-31
 */
public class LinkedList<E> {

    private class Node{
        public E e;
        public Node next;
        public Node(E e,Node next){
            this.e = e;
            this.next = next;
        }
        public Node(E e){
            this(e,null);
        }
        public Node(){
            this(null,null);
        }
        @Override
        public String toString(){
            return e.toString();
        }
    }

    private Node dummyHead;
    private int size;
    public LinkedList(){
        dummyHead = new Node();
        size = 0;
    }

    public int getSize(){
        return size;
    }
    public boolean isEmpty(){
        return size == 0;
    }

    // 在链表的index(0-based)位置添加新的元素e
    public void add(int index, E e){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("Add failed. Illegal index.");
        }
        Node prev = dummyHead;
        for(int i = 0; i < index; i ++){
            prev = prev.next;
        }
        Node node = new Node(e);
        node.next = prev.next;
        prev.next = node;
        size ++;
    }

    // 在链表头添加新的元素e
    public void addFirst(E e){
        add(0,e);
    }
    // 在链表末尾添加新的元素e
    public void addLast(E e){
        add(size,e);
    }

    // 获得链表的第index(0-based)个位置的元素
    // 在链表中不是一个常用的操作，练习用：）
    public E get(int index){
        if(this.isEmpty())
            throw new IllegalArgumentException("get failed. LinkedList is empty");
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Get failed. Illegal index.");
        Node prev = dummyHead.next;
        for(int i = 0; i < index; i ++){
            prev = prev.next;
        }
        return prev.e;
    }

    // 获得链表的第一个元素
    public E getFirst(){
        return get(0);
    }

    // 获得链表的最后的元素
    public E getLast(){
        return get(size - 1);
    }

    // 修改链表的第index(0-based)个位置的元素为e
    // 在链表中不是一个常用的操作，练习用：）
    public void set(int index, E e){
        if(this.isEmpty())
            throw new IllegalArgumentException("set failed. LinkedList is empty");
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("set failed. Illegal index.");
        Node prev = dummyHead.next;
        for(int i = 0; i < index; i ++){
            prev = prev.next;
        }
        prev.e = e;
    }

    // 查找链表中是否有元素e
    public boolean contains(E e){
        Node cur = dummyHead.next;
        while(null != cur){
            if(cur.e.equals(e))
                return true;
            cur = cur.next;
        }
        return false;
    }

    // 从链表中删除index(0-based)位置的元素, 返回删除的元素
    // 在链表中不是一个常用的操作，练习用：）
    public E remove(int index){
        if(this.isEmpty())
            throw new IllegalArgumentException("remove failed. LinkedList is empty");
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("remove failed. Illegal index.");

        Node prev = dummyHead;
        for(int i = 0; i < index; i ++){
            prev = prev.next;
        }
        Node node = prev.next;
        E e = node.e;
        prev.next = node.next;
        node.next = null;
        size --;
        return e;
    }

    // 从链表中删除第一个元素, 返回删除的元素 removeFirst
    public E removeFirst(){
        return remove(0);
    }

    // 从链表中删除最后一个元素, 返回删除的元素 removeLast
    public E removeLast(){
        return remove(size - 1);
    }

    // 从链表中删除元素e
/*    public int removeElement(E e){
        ListNode prev = dummyHead;
        for(int i = 0; i < size; i++){
            if(prev.next.e.equals(e)){
                prev.next = prev.next.next;
                size -- ;
                return i;
            }
            prev = prev.next;
        }
        return -1;
    }*/

    public void removeElement(E e){
        Node prev = dummyHead;
        while(prev.next != null){
            if(prev.next.e.equals(e)){
                break;
            }
            prev = prev.next;
        }

        Node ret = prev.next;
        prev.next = ret.next;
        ret.next = null;
        size --;

    }
    //toString
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("LinkedList: size = %d \n",this.size));
        sb.append("LinkedList: ");
        Node cur = dummyHead.next;
/*        for(int i = 0; i < size; i ++){
            prev = prev.next;
            sb.append(prev.e);
            if(prev.next != null)
                sb.append(" -> ");
        }*/
        while(cur != null){
            sb.append(cur + "->");
            cur = cur.next;
        }
        sb.append("NULL");
        return sb.toString();
    }

    // 链表反转
    public Node reverse(){
        //Node node = new Node();
        Node head = dummyHead.next;
        if (head == null)
            return head;

        Node pre = head;
        Node cur = head.next;
        Node tmp ;
        while(cur != null){
            System.out.println("cur.e--"+cur.e);
            tmp= cur.next;
            cur.next = pre;
            //pre.next = tmp;
            //dummyHead.next = cur;
            pre = cur;
            if(tmp == null){
                dummyHead.next = cur;
                break;
            }
            cur = tmp;
        }
        head.next = null;
        return dummyHead.next;
    }

    /**
     * 递归反转法，从尾结点开始，逆向反转各个结点的指针域指向。
     */
    public Node reverse_d(Node head) {
         //head = dummyHead.next;
        // head看作是前一结点，head.getNext()是当前结点，reHead是反转后新链表的头结点
        System.out.println("head-- " + head.e);
        if (head == null || head.next == null) {
            return head;// 若为空链或者当前结点在尾结点，则直接还回
        }
        Node reHead = reverse_d(head.next);// 先反转后续节点head.getNext()
        Node node = head.next;
        node.next = head;
        //head.next = head;// 将当前结点的指针域指向前一结点
        head.next = null;// 前一结点的指针域令为null;
        return reHead;// 反转后新链表的头结点*/
//        head.getNext().setNext(head);// 将当前结点的指针域指向前一结点
//        head.setNext(null);// 前一结点的指针域令为null;
//        return reHead;// 反转后新链表的头结点
    }

    public void reverse_02(){
        dummyHead.next = reverse_d(dummyHead.next);
    }

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        System.out.println(linkedList.toString());
        for(int i = 0; i < 10; i ++){
            linkedList.addLast(i);
            System.out.println(linkedList.toString());
        }
        System.out.println("------------------");
       // System.out.println("---" + linkedList.reverse());
        linkedList.reverse_02();
        System.out.println("--" + linkedList.toString());


 /*       for(int i = 0; i < 5; i ++){
            linkedList.removeLast();
            System.out.println(linkedList.toString());
        }*/

       // linkedList.removeElement(2);
        //System.out.println(a);
       // System.out.println(linkedList.toString());


    }
}
