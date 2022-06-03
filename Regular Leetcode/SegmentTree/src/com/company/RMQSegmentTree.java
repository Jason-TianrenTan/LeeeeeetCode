package com.company;

public class RMQSegmentTree extends SegmentTree{

    public RMQSegmentTree(int[] _nums) {
        super(_nums);
    }

    @Override
    protected void build(int left, int right, int idx) {
        int mid = (left + right) / 2;
        if (left == right)
            treeNodes[idx] = nums[mid];
        else {
            build(left, mid, idx * 2);
            build(mid + 1, right, idx * 2 + 1);
            treeNodes[idx] = Math.min(treeNodes[idx * 2], treeNodes[idx * 2 + 1]);
        }
    }

    @Override
    public void updateValue(int nodeIndex, int nValue) {
        int diff = nValue - nums[nodeIndex];
        updateValueUtil(0, nums.length - 1, nodeIndex,1, diff);
    }

    private void updateValueUtil(int left, int right, int nodeIndex, int treeIndex, int diff) {
        if (left == right) {//遇到叶子节点\
            treeNodes[treeIndex] += diff;
            nums[nodeIndex] += diff;
        }
        else {
            int mid = (left + right) / 2;
            if (nodeIndex >= left && nodeIndex <= mid)
                updateValueUtil(left, mid, nodeIndex, 2 * treeIndex, diff);
            else updateValueUtil(mid +1, right, nodeIndex, 2 * treeIndex + 1, diff);
            treeNodes[treeIndex] = Math.min(treeNodes[2 * treeIndex], treeNodes[2 * treeIndex + 1]);
        }
    }

    public int queryMin(int queryLeft, int queryRight) {
        if (queryLeft < 0 || queryLeft >= nums.length
                || queryRight < 0 || queryRight >= nums.length
                || queryLeft > queryRight) {
            System.out.println("Error input");
            return -1;
        }
        return queryMinUtil(queryLeft, queryRight, 0, nums.length - 1);
    }

    private int queryMinUtil(int queryLeft, int queryRight, int left, int right) {
        if (left == right)
            return nums[left];
        int mid = (left + right) / 2;
        if (queryLeft > mid) {
            //二者都在右子树
            return queryMinUtil(queryLeft, queryRight, mid + 1, right);
        } else if (queryRight <= mid) {
            //二者都在左子树
            return queryMinUtil(queryLeft, queryRight, left, mid);
        } else {
            //queryLeft在左子树，queryRight在右子树
            return Math.min(queryMinUtil(queryLeft, mid, left, mid),
                    queryMinUtil(mid + 1, queryRight, mid + 1, right));
        }
    }

}
