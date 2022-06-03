package com.company;

public class Main {


    //Definition for a binary tree node.
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
        TreeNode t3, t9 = new TreeNode(9), t20, t15 = new TreeNode(15), t7 = new TreeNode(7);
        t20 = new TreeNode(20, t15, t7);
        t3 = new TreeNode(3, t9, t20);
        System.out.println(sumOfLeftLeaves(null));
    }

    int ans = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null)
            return 0;
        dfs(root);
        return ans;
    }

    private void dfs(TreeNode current) {
        if (current.left != null) {
            TreeNode leftLeaf = current.left;
            if (leftLeaf.left == null && leftLeaf.right == null) {
                ans += leftLeaf.val;
            }
        }

        if (current.left != null)
            dfs(current.left);
        if (current.right != null)
            dfs(current.right);
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
