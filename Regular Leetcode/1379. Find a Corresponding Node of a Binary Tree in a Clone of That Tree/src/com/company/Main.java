package com.company;

import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public void work() {

    }

    public static void main(String[] args) {
        new Main().work();
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (cloned.val == target.val)
            return cloned;
        TreeNode res = null;
        if (original.left != null) {
            if ((res = getTargetCopy(original.left, cloned.left, target)) != null)
                return res;
        }
        if (original.right != null) {
            if ((res = getTargetCopy(original.right, cloned.right, target)) != null)
                return res;
        }
        return null;
    }
}
