package com.company;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        TreeNode(int x, TreeNode l, TreeNode r) {
            val = x;
            left = l;
            right = r;
        }
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null || (root.left == null && root.right == null) )
            return true;
        return isSym(root.left, root.right);
    }

    public boolean isSym(TreeNode A, TreeNode B) {
        if (A == null || B == null)
            return false;
        return isSym(A.left, B.right) && isSym(A.right, B.left);
    }

    public void work() {

    }

    public static void main(String[] args) {
        new Main().work();
    }
}
