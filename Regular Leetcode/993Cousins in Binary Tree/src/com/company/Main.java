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

    public TreeNode initTree() {
        TreeNode t1, t2, t3, t4, t5;
        t4 = new TreeNode(4);
        t5 = new TreeNode(5);
        t2 = new TreeNode(2, null, t4);
        t3 = new TreeNode(3, null, t5);
        t1 = new TreeNode(1, t2, t3);
        return t1;
    }

    TreeNode p1, p2;
    int findDepth(TreeNode current, int val, int depth, TreeNode parent) {
        if (current.val == val) {
            if (p1 == null)
                p1 = parent;
            else p2 = parent;
            return depth;
        }
        if (current.left != null) {
            int result = findDepth(current.left, val, depth + 1, current);
            if (result >= 0)
                return result;
        }
        if (current.right != null) {
            int result = findDepth(current.right, val, depth + 1, current);
            if (result >= 0)
                return result;
        }
        return -1;
    }

    public boolean isCousins(TreeNode root, int x, int y) {
        int d1 = findDepth(root, x, 0, null);
        int d2 = findDepth(root, y, 0, null);
    //    System.out.println(d1 + ", " + d2);
        return d1 == d2 && p1 != p2;
    }

    public void work() {
        TreeNode root = initTree();
        int x = 3, y = 2;
    //    System.out.println(isCousins(root, x, y));
    }


    public static void main(String[] args) {
        new Main().work();
    }
}
