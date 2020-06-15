package com.datastructure.chapter_05_binary_search_tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @date : 2019-12-11
 *
 * 二分搜索树
 */
public class BSTree2<E extends Comparable<E>>{

    private class Node{
        Node left;
        Node right;
        E e;
        public Node(Node left, Node right, E e){
            this.left = left;
            this.right = right;
            this.e = e;
        }
        public Node(E e){
            this(null,null,e);
        }
        public Node(){
            this(null,null,null);
        }

    }

    private int size;
    private Node root;
    public int size(){
        return this.size;
    }

    public boolean isEmpty(){
        return this.size == 0;
    }


    // 向二分搜索树中添加新的元素e

    // 向以node为根的二分搜索树中插入元素e，递归算法
    public void add(E e){
        root = add(root,e);
    }
    // 向以node为根的二分搜索树中插入元素e，递归算法
    // 返回插入新节点后二分搜索树的根
    private Node add(Node node, E e) {
        if(node == null){
            size ++;
            return new Node(e);
        }
        if(e.compareTo(node.e) < 0){
            node.left = add(node.left, e);
        }else{
            node.right = add(node.right,e);
        }
        return node;
    }

    // 看二分搜索树中是否包含元素e
    public boolean contains(E e){
        return contains(root, e);
    }
    // 看以node为根的二分搜索树中是否包含元素e, 递归算法
    private boolean contains(Node node, E e){
        if(node == null){
            return false;
        }
        if(e.compareTo(node.e) < 0){
            return contains(node.left, e);
        }else if(e.compareTo(node.e) > 0){
            return contains(node.left, e);
        }else{
            return true;
        }
    }

    // 二分搜索树的前序遍历
    public void preOrder(){
        preOrder(root);
    }

    // 前序遍历以node为根的二分搜索树, 递归算法
    private void preOrder(Node node) {
        if(node == null)
            return;
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    // 二分搜索树的中序遍历
    public void inOrder(){
        inOrder(root);
    }

    // 中序遍历以node为根的二分搜索树, 递归算法
    private void inOrder(Node node) {
        if(node == null)
            return;
        preOrder(node.left);
        System.out.println(node.e);
        preOrder(node.right);
    }

    // 二分搜索树的后序遍历
    public void postOrder(){
        postOrder(root);
    }

    private void postOrder(Node node) {
        if(node == null)
            return;
        preOrder(node.left);
        preOrder(node.right);
        System.out.println(node.e);
    }

    // 二分搜索树的层序遍历，一层一层遍历
    public void levelOrder(){
        if(root == null)
            return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node cur = queue.remove();
            System.out.println(cur.e);
            if(cur.left != null)
                queue.add(cur.left);
            if(cur.right != null)
                queue.add(cur.right);
        }

    }
    // 二分搜索树的非递归前序遍历
    public void preOrderNR(){
        if(root == null)
            return;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            Node cur = stack.pop();
            System.out.println(cur.e);
            if(cur.left != null)
                stack.push(cur.left);
            if(cur.right != null)
                stack.push(cur.right);
        }
    }

    // 二分搜索树的非递归中序遍历
    public void inOrderNR(){

    }

    // 二分搜索树的非递归中序遍历
    public void postOrderNR(){

    }


    // 寻找二分搜索树的最小元素
    public E minimum(){
       if(size == 0)
           throw new IllegalArgumentException("BSTree is empty!");

       return minimum(root).e;
    }

    // 返回以node为根的二分搜索树的最小值所在的节点
    private Node minimum(Node node){
        if(node.left == null){
            return node;
        }
        return minimum(node.left);
    }

    // 寻找二分搜索树的最大元素
    public E maximum(){
        if(size == 0)
            throw new IllegalArgumentException("BSTree is empty!");
        return maximum(root).e;
    }

    // 返回以node为根的二分搜索树的最大值所在的节点
    private Node maximum(Node node){
        if(node.right == null){
            return node;
        }
        return minimum(node.right);
    }

    // 从二分搜索树中删除最小值所在节点, 返回最小值
    public E removeMin(){
        E e = minimum();
        root = removeMin(root);
        return e;
    }

    // 删除掉以node为根的二分搜索树中的最小节点
    // 返回删除节点后新的二分搜索树的根
    private Node removeMin(Node node){
        if(node.left == null){
          Node rightNode = node.right;
          node.right = null;
          size --;
          return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    // 从二分搜索树中删除最大值所在节点
    public E removeMax(){
        E e = maximum();
        root = removeMax(root);
        return e;
    }

    // 删除掉以node为根的二分搜索树中的最大节点
    // 返回删除节点后新的二分搜索树的根
    private Node removeMax(Node node){
        if(node.right == null){
            Node leftNode = node.left;
            node.left = null;
            size --;
            return leftNode;
        }
        node.right = removeMax(node.right);
        return node;
    }

    // 从二分搜索树中删除元素为e的节点
    public void remove(E e){
        root = remove(root, e);
    }

    // 删除掉以node为根的二分搜索树中值为e的节点, 递归算法
    // 返回删除节点后新的二分搜索树的根
    private Node remove(Node node, E e) {
        if(node == null)
            return node;
        if(e.compareTo(node.e) < 0){
            node.left = remove(node.left, e);
            return node;
        }else if(e.compareTo(node.e) > 0){
            node.right = remove(node.right, e);
            return node;
        }else {
            if(node.left == null){
                Node rightNode = node.right;
                node.right = null;
                size --;
                return rightNode;
            }
            if(node.right == null){
                Node leftNode = node.left;
                node.left = null;
                size --;
                return leftNode;
            }
            // 待删除节点左右子树均不为空的情况
            // 找到比待删除节点大的最小节点, 即待删除节点右子树的最小节点
            // 用这个节点顶替待删除节点的位置
            Node mvNode = minimum(node.right);
            mvNode.left = node.left;
            mvNode.right = removeMin(node.right);
            node.left = null;
            node.right = null;
            return mvNode;
        }
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        generateBSTString(root,0,sb);
        return sb.toString();
    }

    // 生成以node为根节点，深度为depth的描述二叉树的字符串
    private void generateBSTString(Node node, int depth, StringBuilder res){
        if(node == null){
            res.append(generateDepthString(depth) + "null \n");
            return;
        }
        res.append(generateDepthString(depth) + node.e + "\n");
        generateBSTString(node.left, depth + 1, res);
        generateBSTString(node.right, depth + 1, res);

    }

        private String generateDepthString(int depth){
            StringBuilder res = new StringBuilder();
            for(int i = 0 ; i < depth ; i ++)
                res.append("--");
            return res.toString();
        }

}
