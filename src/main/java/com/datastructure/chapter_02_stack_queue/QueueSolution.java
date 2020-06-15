package com.datastructure.chapter_02_stack_queue;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

/**
 * @date : 2019-10-30
 *
 *    Leetcode 102. Binary Tree Level Order Traversal
 *    https://leetcode.com/problems/binary-tree-level-order-traversal/description/
 *    二叉树的层序遍历
 *
 *    二叉树的层序遍历是一个典型的可以借助队列解决的问题。
 *    该代码主要用于使用Leetcode上的问题测试我们的ArrayQueue。
 */
public class QueueSolution {

    /// Definition for a binary tree node.

    public List<List<Integer>> levelOrderByArrayQueue(TreeNode root) {

        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root == null)
            return res;

        // 我们使用LinkedList来做为我们的先入先出的队列
        ArrayQueue<Pair<TreeNode, Integer>> queue = new ArrayQueue<Pair<TreeNode, Integer>>();
        queue.enqueue(new Pair<TreeNode, Integer>(root, 0));

        while(!queue.isEmpty()){

            Pair<TreeNode, Integer> front = queue.dequeue();
            TreeNode node = front.getKey();
            int level = front.getValue();

            if(level == res.size())
                res.add(new ArrayList<Integer>());
            assert level < res.size();

            res.get(level).add(node.val);
            if(node.left != null)
                queue.enqueue(new Pair<TreeNode, Integer>(node.left, level + 1));
            if(node.right != null)
                queue.enqueue(new Pair<TreeNode, Integer>(node.right, level + 1));
        }

        return res;
    }


    /**
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderByLoopQueue(TreeNode root) {

        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root == null)
            return res;

        // 我们使用LinkedList来做为我们的先入先出的队列
        LoopQueue<Pair<TreeNode, Integer>> queue = new LoopQueue<Pair<TreeNode, Integer>>();
        queue.enqueue(new Pair<TreeNode, Integer>(root, 0));

        while(!queue.isEmpty()){

            Pair<TreeNode, Integer> front = queue.dequeue();
            TreeNode node = front.getKey();
            int level = front.getValue();

            if(level == res.size())
                res.add(new ArrayList<Integer>());
            assert level < res.size();

            res.get(level).add(node.val);
            if(node.left != null)
                queue.enqueue(new Pair<TreeNode, Integer>(node.left, level + 1));
            if(node.right != null)
                queue.enqueue(new Pair<TreeNode, Integer>(node.right, level + 1));
        }

        return res;
    }
}
