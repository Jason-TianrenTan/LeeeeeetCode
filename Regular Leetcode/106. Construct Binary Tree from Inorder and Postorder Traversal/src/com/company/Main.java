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

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int count = inorder.length;
        int rootVal = postorder[postorder.length - 1];
        TreeNode rootNode = new TreeNode(rootVal);
        int rootIndex = 0;
        for (int i = 0; i < count; i++) {
            if (rootVal == inorder[i]) {
                rootIndex = i;
                break;
            }
        }
        //There are rootIndex left nodes
        int[] leftIn = new int[rootIndex], rightIn = new int[count - 1 - rootIndex];
        int[] leftPost = new int[rootIndex], rightPost = new int[count - 1 - rootIndex];
        for (int i = 0; i < rootIndex; i++) {
            leftIn[i] = inorder[i];
            leftPost[i] = postorder[i];
        }
        for (int i = rootIndex + 1; i < count; i++) {
            rightIn[i] = inorder[i];
            rightPost[i] = postorder[i];
        }
        rootNode.left = buildTree(leftIn, leftPost);
        rootNode.right = buildTree(rightIn, rightPost);
        return rootNode;
    }

    public void work() {

    }

    public static void main(String[] args) {
        new Main().work();
    }
}
