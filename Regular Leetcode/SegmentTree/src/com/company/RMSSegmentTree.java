package com.company;

public class RMSSegmentTree extends SegmentTree{

    public RMSSegmentTree(int[] _nums) {
        super(_nums);
    }

    //A[l,r] = A[l, (l + r)/2] + A[(l+r)/2 + 1, r]
    @Override
    protected void build(int left, int right, int idx) {
        int mid = (left + right) / 2;
        if (left == right)
            treeNodes[idx] = nums[mid];
        else {
            build(left, mid, 2 * idx);
            build(mid + 1, right, 2 * idx + 1);
            treeNodes[idx] = treeNodes[2 * idx] + treeNodes[2 * idx + 1];
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
            treeNodes[treeIndex] = treeNodes[2 * treeIndex] + treeNodes[2 * treeIndex + 1];
        }
    }

    public int querySum(int queryLeft, int queryRight) {
        for (int i : treeNodes)
            System.out.print(i + " ");
        System.out.println();
        if (queryLeft < 0 || queryLeft >= nums.length
                || queryRight < 0 || queryRight >= nums.length
                || queryLeft > queryRight) {
            System.out.println("Error input");
            return -1;
        }
        return querySumUtil(queryLeft, queryRight, 0, nums.length - 1, 1);
    }
    //0 <= left, right < n
    private int querySumUtil(int queryLeft, int queryRight, int left, int right, int index) {
        System.out.println("Query [" + left + ", " + right + "], index = " + index);
        if (left == right) {
            System.out.println("Returning " + treeNodes[index]);
            return treeNodes[index];
        }
        int mid = (left + right) / 2;
        System.out.println("Mid = " + mid);
        if (queryLeft > mid) {
            //二者都在右子树
            System.out.println("Going to right tree");
            return querySumUtil(queryLeft, queryRight, mid + 1, right, index * 2 + 1);
        } else if (queryRight <= mid) {
            //二者都在左子树
            System.out.println("Going to left tree");
            return querySumUtil(queryLeft, queryRight, left, mid, index * 2);
        } else {
            //queryLeft在左子树，queryRight在右子树
            System.out.println("Splitting into left + right");
            return querySumUtil(queryLeft, mid, left, mid, index * 2)
                    + querySumUtil(mid + 1, queryRight, mid + 1, right, index * 2 + 1);
        }
    }
}
