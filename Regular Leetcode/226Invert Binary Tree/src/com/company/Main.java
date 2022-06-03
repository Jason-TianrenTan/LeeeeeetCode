package com.company;

import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public void flip(TreeNode current) {
        if (current == null)
            return;
        TreeNode temp = current.left;
        current.left = current.right;
        current.right = temp;
        flip(current.left);
        flip(current.right);
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;
        flip(root);
        return root;
    }

    public void bfs(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode top = queue.poll();
            System.out.print(top.val + " ");
            if (top.left != null)
                queue.add(top.left);
            if (top.right != null)
                queue.add(top.right);
        }
        System.out.println();
    }

    public void work() {
        TreeNode t1 = new TreeNode(1), t3 = new TreeNode(3), t6 = new TreeNode(6), t9 = new TreeNode(9);
        TreeNode t2 = new TreeNode(2, t1, t3), t7 = new TreeNode(7, t6, t9), t4 = new TreeNode(4, t2, t7);
        TreeNode root = t4;
        root = invertTree(root);

        bfs(root);
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
