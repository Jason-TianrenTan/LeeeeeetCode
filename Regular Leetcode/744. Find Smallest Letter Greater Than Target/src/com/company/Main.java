package com.company;

public class Main {

    public char nextGreatestLetter(char[] letters, char target) {
        int low = 0, high = letters.length;
        if (target >= letters[high - 1])
            return letters[0];
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (letters[mid] > target)
                high = mid;
            else low = mid + 1;
        }
        return letters[high];
    }

    public void work() {
        char[] letters = {'d'};
        System.out.println(nextGreatestLetter(letters, 'm'));
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
