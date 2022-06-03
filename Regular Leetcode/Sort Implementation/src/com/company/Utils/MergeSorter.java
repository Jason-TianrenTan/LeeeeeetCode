package com.company.Utils;

public class MergeSorter extends Sorter{

    @Override
    public void sort(String[] arr) {
        MergeSort(arr, 0, arr.length - 1);
    }

    private void MergeSort(String[] arr, int left, int right) {
        if (left >= right)
            return;
        int middle = (left + right) / 2;
        MergeSort(arr, left, middle);
        MergeSort(arr, middle + 1, right);
        merge(arr, left, right, middle);
    }

    private void merge(String[] arr, int left, int right, int middle) {
        int pt1 = left, pt2 = middle + 1;
        String[] res = new String[right - left + 1];
        int index = 0;
        while (pt1 <= middle && pt2 <= right) {
            if (arr[pt1].compareTo(arr[pt2]) < 0)
                res[index++] = arr[pt1++];
            else res[index++] = arr[pt2++];
        }

        while (pt1 <= middle)
            res[index++] = arr[pt1++];
        while (pt2 <= right)
            res[index++] = arr[pt2++];
        for (int i=left;i<=right;i++)
            arr[i] = res[i - left];
    }
}
