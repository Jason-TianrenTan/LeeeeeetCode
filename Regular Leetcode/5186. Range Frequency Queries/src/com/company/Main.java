package com.company;

import java.util.HashMap;
import java.util.Map;

public class Main {

    Map<Integer, Map<Integer, Map<Integer, Integer>>> cache;//cache.(val, left, right) = count of val in [left, right]

    public abstract class SegmentTree {

        //    public int[] treeNodes;
        public Map<Integer, Integer>[] treeNodes;
        public int[] nums;
        public int treeSize = 0;

        public SegmentTree(int[] _nums) {
            this.nums = _nums;
            for (int i : this.nums)
                cache.putIfAbsent(i, new HashMap<>());
            this.createTree();
        }

        protected int find2Power(int n) {
            if ((n & (n - 1)) == 0)
                return 0;
            int power = 0;
            while (n != 0) {
                n >>= 1;
                power++;
            }
            return (int) Math.pow(2.0, power);
        }

        private void createTree() {
            find2Power(4);
            int n = nums.length;
            treeSize = 2 * find2Power(n) - 1;
            treeNodes = new HashMap[treeSize + 1];
            for (int i = 0; i <= treeSize; i++)
                treeNodes[i] = new HashMap<>();
            build(0, n - 1, 1);
        }

        protected abstract void build(int left, int right, int idx);

    }

    public class RFQSegmentTree extends SegmentTree {

        public RFQSegmentTree(int[] _nums) {
            super(_nums);
        }

        @Override
        protected void build(int left, int right, int idx) {
            int mid = (left + right) / 2;
            if (left == right)
                treeNodes[idx].put(nums[mid], 1);
            else {
                build(left, mid, idx * 2);
                build(mid + 1, right, idx * 2 + 1);
                treeNodes[2 * idx].forEach((k, v) -> treeNodes[idx].merge(k, v, Integer::sum));
                treeNodes[2 * idx + 1].forEach((k, v) -> treeNodes[idx].merge(k, v, Integer::sum));
                //    treeNodes[idx] = treeNodes[2 * idx] + treeNodes[2 * idx + 1];
                //    treeNodes[idx] = Math.min(treeNodes[idx * 2], treeNodes[idx * 2 + 1]);
            }
        }

        public int queryFrequency(int queryLeft, int queryRight, int val) {
            if (queryLeft < 0 || queryLeft >= nums.length
                    || queryRight < 0 || queryRight >= nums.length
                    || queryLeft > queryRight) {
                System.out.println("Error input");
                return -1;
            }
            return queryFreqUtil(queryLeft, queryRight, 0, nums.length - 1, 1, val);
        }

        //0 <= left, right < n
        private int queryFreqUtil(int queryLeft, int queryRight, int left, int right, int index, int val) {
            if (left == right) {
                return treeNodes[index].getOrDefault(val, 0);
            }
            if (cache.get(val).containsKey(left) && cache.get(val).get(left).containsKey(right)) {
                return cache.get(val).get(left).get(right);
            }
            cache.get(val).putIfAbsent(left, new HashMap<>());
            int mid = (left + right) / 2;
            int cnt = 0;
            if (queryLeft > mid) {
                //二者都在右子树
                cnt = queryFreqUtil(queryLeft, queryRight, mid + 1, right, index * 2 + 1, val);
            } else if (queryRight <= mid) {
                //二者都在左子树
                cnt = queryFreqUtil(queryLeft, queryRight, left, mid, index * 2, val);
            } else {
                //queryLeft在左子树，queryRight在右子树
                cnt = queryFreqUtil(queryLeft, mid, left, mid, index * 2, val) +
                        queryFreqUtil(mid + 1, queryRight, mid + 1, right, index * 2 + 1, val);
            }
            cache.get(val).get(left).put(right, cnt);
            return cnt;
        }

    }


    public void work() {
        cache = new HashMap<>();
        int[] nums = {12, 33, 4, 56, 22, 2, 34, 33, 22, 12, 34, 56};
        RFQSegmentTree tree = new RFQSegmentTree(nums);
        System.out.println(tree.queryFrequency(0, 11, 33));
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
