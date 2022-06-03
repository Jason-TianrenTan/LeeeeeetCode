package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    int[] numbers;
    ArrayList<List<Integer>> ans;
    public void find(int index, List<Integer> subset) {
        if (index == numbers.length) {
            ans.add(subset);
            return;
        }
        find(index + 1, subset);//不取
        ArrayList<Integer> save = new ArrayList<>(subset);
        save.add(numbers[index]);//取
        find(index + 1, save);
    }

    public List<List<Integer>> subsets(int[] nums) {
        numbers = nums;
        ans = new ArrayList<>();
        find(0, new ArrayList<Integer>());
        return ans;
    }

    public void work() {
        int[] nums = {1,2,3};
        subsets(nums);
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
