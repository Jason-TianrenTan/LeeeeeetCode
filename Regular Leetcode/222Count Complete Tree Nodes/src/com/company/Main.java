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

//    int missing = 0;
//    int height;
//    boolean hasMissing = false;
//
//    public void dfs(TreeNode node, int curHeight) {
//        if (node.right == null) {
//            if (curHeight < height) {
//                missing++;
//                hasMissing = true;
//                if (node.left == null)
//                    missing++;
//            }
//        } else {
//            hasMissing = false;
//            dfs(node.right, curHeight + 1);
//            if (hasMissing)
//                dfs(node.left, curHeight + 1);
//        }
//    }
//
//
//    public int countNodes(TreeNode root) {
//        if (root == null)
//            return 0;
//        //find height
//        height = findHeight(root);
//        dfs(root, 1);
//        return (int)Math.pow(2.0, height) - 1 - missing;
//    }

    public int findHeight(TreeNode node) {
        if (node == null)
            return 0;
        return findHeight(node.left) + 1;
    }

    public boolean findNode(TreeNode current, int idx, int left, int right) {
        if (idx == 1)
            return true;
        if (left == right)
            return current != null;
        int mid = left + (right - left) / 2;
        if (idx <= mid) {
            //move left
            return findNode(current.left, idx, left, mid);
        } else return findNode(current.right, idx, mid + 1, right);
    }

    public int countNodes(TreeNode root) {
        if (root == null)
            return 0;
        //find height
        int height = findHeight(root);//range:1 -> 2^h
        int left = 1, right = (int)Math.pow(2.0, height - 1);
        int rightBound = right;
        int mid = 0;
        if (findNode(root, rightBound, 1, rightBound))
            return 2 * rightBound - 1;
        while (left <= right) {
            mid = left + (right - left) / 2;
            System.out.println(left + ", " + right + ", mid = " + mid);
            if (findNode(root, mid, 1, rightBound)) {//right half
                System.out.println("Found " + mid + ", left = " + (mid + 1));
                left = mid + 1;
            }
            else right = mid - 1;
        }
        return rightBound - 2 + left;

        //dfs(root, 1);
        //return (int)Math.pow(2.0, height) - 1 - missing;
    }

    public void work() {
        TreeNode A,B,C,D,E,F,G,H,I,J,K,L;
        H = new TreeNode('H');
        I = new TreeNode('I');
        J = new TreeNode('J');
        K = new TreeNode('K');
        L = new TreeNode('L');
        G = new TreeNode('G');
        D = new TreeNode('D', H, null);
        E = new TreeNode('E');
        //
        F = new TreeNode('F', null, null);
        B = new TreeNode('B', D, E);
        C = new TreeNode('C', F, G);
        A = new TreeNode('A', B, C);
        System.out.println(countNodes(A));
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
