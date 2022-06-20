package com.company;

public class Main {

    public boolean validPalindrome(String s) {
        char[] arr = s.toCharArray();
        int left = 0, right = arr.length - 1;
        while (arr[left] == arr[right] && left < right) {
            System.out.println(s.substring(left, right + 1));
            left++;
            right--;
        }
        if (left < right) {
            if (arr[left + 1] == arr[right]) {
                int st = left + 1, ed = right;
                while (arr[st] == arr[ed] && st < ed) {
                    System.out.println(s.substring(st, ed + 1));
                    st++;
                    ed--;
                }
                if (st >= ed)
                    return true;
            } if (arr[left] == arr[right - 1]) {
                int st = left, ed = right - 1;
                while (arr[st] == arr[ed] && st < ed) {
                    st++;
                    ed--;
                }
                if (st >= ed)
                    return true;
            }
            return false;
        }
        return true;
    }

    public void work() {
        System.out.println(validPalindrome("aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga"));
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
