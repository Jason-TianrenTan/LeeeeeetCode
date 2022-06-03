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

    double minDiff;
    int pos;

    public void findClosest(TreeNode current, double target) {
        if (current.val >= target) {
            if (current.val - target < minDiff) {
                minDiff = current.val - target;
                pos = current.val;
            }
            if (current.left != null)
                findClosest(current.left, target);
        }

        else {
            if (target - current.val < minDiff) {
                minDiff = target - current.val;
                pos = current.val;
            }
            if (current.right != null)
                findClosest(current.right, target);
        }
    }

    public int closestValue(TreeNode root, double target) {
        minDiff = Double.MAX_VALUE;
        pos = root.val;
        findClosest(root, target);
        return pos;
    }

    public void work() {
        TreeNode t1 = new TreeNode(1);
        System.out.println(closestValue(t1, 3.2));
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
