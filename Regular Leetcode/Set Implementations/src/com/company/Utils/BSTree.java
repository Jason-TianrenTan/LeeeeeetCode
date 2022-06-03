package com.company.Utils;

public class BSTree {

    TreeNode root;
    int size = 0;

    public class TreeNode {
        String word;
        TreeNode left, right;

        public TreeNode(String word) {
            this.word = word;
        }
    }

    public BSTree() {
    }

    private boolean insertNode(String word, TreeNode current) {
        if (word.equals(current.word)) {
            return false;
        }
        if (word.compareTo(current.word) < 0) {
            if (current.left == null) {
                current.left = new TreeNode(word);
                size++;
                return true;
            }
            return insertNode(word, current.left);
        } else {
            if (current.right == null) {
                current.right = new TreeNode(word);
                size++;
                return true;
            }
            return insertNode(word, current.right);
        }
    }

    /*
    public void traverse() {
        dfs(root);
    }

    private void dfs(TreeNode current) {
        System.out.println(current.word);
        if (current.left != null)
            dfs(current.left);
        if (current.right != null)
            dfs(current.right);
    }*/

    public boolean insertNode(String word) {
        if (root == null) {
            root = new TreeNode(word);
            size = 1;
            return true;
        }
        return insertNode(word, root);
    }

    public boolean contains(String word) {
        return traverse(word, root);
    }

    private boolean traverse(String word, TreeNode pos) {
        if (pos == null)
            return false;
        if (word.equals(pos.word))
            return true;
        if (word.compareTo(pos.word) < 0)
            return traverse(word, pos.left);
        return traverse(word, pos.right);
    }

    public int size() {
        return this.size;
    }

}
