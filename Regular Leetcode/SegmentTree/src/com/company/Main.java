package com.company;

public class Main {

    public void work() {
        int[] nodes = {1,3,5,7,9,11};
//        RMSSegmentTree segmentTree = new RMSSegmentTree(nodes);
//        int sum = segmentTree.querySum(3, 5);
//        System.out.println(sum);
        RMSSegmentTree segmentTree = new RMSSegmentTree(nodes);
        System.out.println(segmentTree.querySum(0, 2));
        System.out.println(segmentTree.querySum(3, 4));
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
