package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
        q.add(root);
        q.add(null);
        List<List<Integer>> output = new ArrayList<>();
        List<Integer> level = new ArrayList<>();
        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            if (curr == null) {
                //end of level
                output.add(level);
                level = new ArrayList<>();
                q.add(null);
            } else {
                level.add(curr.val);
                if (curr.left != null)
                    q.add(curr.left);
                if (curr.right != null)
                    q.add(curr.right);
            }
        }
        return output;
    }

    public static void main(String[] args) {
	// write your code here
    }
}
