package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    List<Integer> masks;

    public int maxLength(List<String> arr) {
        masks = new ArrayList<>();
        int ans = 0;
        for (String str : arr) {
            int bNum = 0;
            boolean flag = true;
            char[] ch_arr = str.toCharArray();
            for (char c : ch_arr) {
                int digit = 1 << (26 - c + 'a');
                if ((digit & bNum) != 0) {
                    flag = false;
                    break;
                }
                bNum = digit | bNum;
            }
            if (flag) {
                ans = Math.max(ans, Integer.bitCount(bNum));
                int size = masks.size();
                masks.add(bNum);
                for (int i = 0; i < size; i++) {
                    int m = masks.get(i);
                    if ((m & bNum) == 0) {
                        masks.add(m | bNum);
                        ans = Math.max(ans, Integer.bitCount(m | bNum));
                    }
                }
            }
        }

        return ans;
    }


    public void work() {
        String[] strs = {"aab", "ab", "abcd"};
        List<String> arr = new ArrayList<>();
        for (String str : strs)
            arr.add(str);
        System.out.println(maxLength(arr));
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
