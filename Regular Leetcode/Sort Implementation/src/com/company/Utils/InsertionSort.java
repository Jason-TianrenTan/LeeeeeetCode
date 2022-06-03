package com.company.Utils;

public class InsertionSort extends Sorter {

    @Override
    public void sort(String[] arr) {
        InsertionSort(arr);
    }

    private void InsertionSort(String[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j = i - 1;
            String key = arr[i];
            while (j >= 0 && arr[j].compareTo(key) > 0) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
}
