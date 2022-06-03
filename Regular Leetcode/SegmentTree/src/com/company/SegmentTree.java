package com.company;

public abstract class SegmentTree {

    public int[] treeNodes;
    public int[] nums;
    public int treeSize = 0;

    public SegmentTree(int[] _nums) {
        this.nums = _nums;
        this.createTree();
    }

    public void printTree() {
        for (int i=1;i<=treeSize;i++)
            System.out.print(treeNodes[i] + " ");
        System.out.println();
    }

    protected int find2Power(int n) {
        if ((n & (n - 1)) == 0)
            return 0;
        int power = 0;
        while (n != 0) {
            n >>= 1;
            power++;
        }
        return (int)Math.pow(2.0, power);
    }

    private void createTree() {
        find2Power(4);
        int n = nums.length;
        treeSize = 2 * find2Power(n) - 1;
        treeNodes = new int[treeSize + 1];
        build(0, n - 1, 1);
    }

    protected abstract void build(int left, int right, int idx);

    public abstract void updateValue(int nodeIndex, int nValue);


}
