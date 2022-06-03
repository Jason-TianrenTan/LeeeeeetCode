package com.company;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int[] levelOrder(TreeNode root) {

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        List<Integer> output = new ArrayList<>();
        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            if (curr == null)
                continue;
            output.add(curr.val);
            q.add(curr.left);
            q.add(curr.right);
        }
        return output.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        // write your code here
    }
}
