package com.company;

public class Main {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode mirrorTree(TreeNode root) {
        if (root == null)
            return null;
        TreeNode mirrorLeft = mirrorTree(root.left),
                mirrorRight = mirrorTree(root.right);
        root.left = mirrorRight;
        root.right = mirrorLeft;
        return root;
    }

    public void work() {

    }

    public static void main(String[] args) {
        new Main().work();
    }
}
