package com.company;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

    ArrayList<TreeNode> nodeList = new ArrayList<>();

    public void inOrderTraverse(TreeNode current) {
        if (current == null)
            return;
        inOrderTraverse(current.left);
        nodeList.add(current);
        inOrderTraverse(current.right);
    }

    public double dist(int idx, double target) {
        return Math.abs(nodeList.get(idx).val - target);
    }

    public int partition(int left, int right, double target) {
        int pivot = right;
        int firstHigh = left;
        for (int i = left; i < right; i++) {
            if (dist(i, target) < dist(pivot, target)) {
                Collections.swap(nodeList, i, firstHigh);
                firstHigh++;
            }
        }
        Collections.swap(nodeList, firstHigh, pivot);
        System.out.print("Nodes: ");
        for (TreeNode node : nodeList) {
            System.out.print(node.val + " ");
        }
        System.out.println();
        return firstHigh;
    }

    public void findKthClosest(int left, int right, double target, int k) {
        int partition = partition(left, right, target);
        if (partition == k - 1)
            return;
        if (partition > k - 1)
            findKthClosest(left, partition - 1, target, k);
        else findKthClosest(partition + 1, right, target, k);
    }

    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        //inorder traverse
        inOrderTraverse(root);
        int left = 0, right = nodeList.size() - 1;
        findKthClosest(left, right, target, k);
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < k; i++)
            res.add(nodeList.get(i).val);
        return res;
    }

    public void work() {
        TreeNode t1 = new TreeNode(1);

    }

    public static void main(String[] args) {
        new Main().work();
    }
}
