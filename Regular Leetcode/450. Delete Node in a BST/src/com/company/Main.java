package com.company;

import java.util.HashMap;
import java.util.Map;

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

    public TreeNode deleteNode(TreeNode root, int k) {
        if (root == null)
            return null;
        if (root.val == k) {
            if (root.left == null && root.right == null)
                root = null;
            else if (root.left != null) {
                root.val = predecessor(root);
                root.left = deleteNode(root.left, k);
            }
            else if (root.right != null) {
                root.val = successor(root);
                root.right = deleteNode(root.right, k);
            }
        }
        else if (root.val < k)
            root.right = deleteNode(root.right, k);
        else root.left = deleteNode(root.left, k);
        return root;
    }

    int successor(TreeNode node) {
        node = node.right;
        while (node.left != null)
            node = node.left;
        return node.val;
    }

    int predecessor(TreeNode node) {
        node = node.left;
        while (node.right != null)
            node = node.right;
        return node.val;
    }

    public void work() {
        TreeNode t2 = new TreeNode(2), t4 = new TreeNode(4), t7 = new TreeNode(7),
                t3 = new TreeNode(3, t2, t4), t6 = new TreeNode(6, null, t7),
                t5 = new TreeNode(5, t3, t6);
        deleteNode(t5, 3);
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
