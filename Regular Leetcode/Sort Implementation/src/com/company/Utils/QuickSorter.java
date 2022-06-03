package com.company.Utils;

public class QuickSorter extends Sorter {

    @Override
    public void sort(String[] arr) {
        QuickSort(arr, 0, arr.length - 1);
    }

    private void QuickSort(String[] arr, int left, int right) {
        if (right <= left)
            return;
        int pivot = partition(arr, left, right);
        QuickSort(arr, left, pivot - 1);
        QuickSort(arr, pivot + 1, right);
    }

    private int partition(String[] arr, int left, int right) {
        int pivot = right;
        int firstHigh = left;
        for (int i = left; i <= right; i++) {
            if (arr[i].compareTo(arr[pivot]) < 0) {
                //swap i with firstHigh
                swap(arr, i, firstHigh);
                firstHigh++;
            }
        }
        swap(arr, pivot, firstHigh);
        return firstHigh;
    }
}
