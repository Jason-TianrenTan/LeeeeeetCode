package com.company;

import java.util.*;

public class Main {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> output = new ArrayList<>();
        if (root != null)
            q.add(root);
        int dir = 1;
        while (!q.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int total = q.size();
            for (int i = 0; i < total; i++) {
                TreeNode node = q.poll();
                level.add(node.val);
                if (node.left != null)
                    q.add(node.left);
                if (node.right != null)
                    q.add(node.right);
            }
            if (dir < 0) {
                for (int i = 0; i < total / 2; i++) {
                    int temp = level.get(i);
                    level.set(i, level.get(total - 1 - i));
                    level.set(total - 1 - i, temp);
                }
            }
            output.add(level);
            dir = -dir;
        }
        return output;
    }


    /**
     * Very interesting...
     * 3
     * 1 -> 2 -> 4 -> 3 ->
     * 2
     * 1 -> 4 -> 2 -> 4 -> 3 ->
     * 1
     * 4 -> 1 -> 4 -> 2 -> 4 -> 3 ->
     *
     * @param args
     */
    public static void main(String[] args) {
        // write your code here

    }
}
