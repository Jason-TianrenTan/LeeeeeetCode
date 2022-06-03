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
        TreeNode t1, t2 = new TreeNode(2), t3 = new TreeNode(3);
        t1 = new TreeNode(1, t2, t3);
        System.out.println(sumNumbers(t1));
    }

    int ans = 0;

    public int sumNumbers(TreeNode root) {
        dfs(root, 0);
        return ans;
    }

    private void dfs(TreeNode current, int val) {
        val = val * 10 + current.val;
        if (current.left == null && current.right == null) {
            ans += val;
            return;
        }
        if (current.left != null)
            dfs(current.left, val);
        if (current.right != null)
            dfs(current.right, val);
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
