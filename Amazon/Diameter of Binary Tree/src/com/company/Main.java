package com.company;

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

    public void work() {

    }

    int maxPath = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        longestDepth(root);
        return maxPath;
    }

    private int longestDepth(TreeNode node) {
        if (node == null)
            return 0;
        int left = longestDepth(node.left), right = longestDepth(node.right);
        maxPath = Math.max(left + right, maxPath);
        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
