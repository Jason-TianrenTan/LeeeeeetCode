package com.company.Utils;

public class SelectionSorter extends Sorter{

    @Override
    public void sort(String[] arr) {
        SelectionSort(arr);
    }

    private void SelectionSort(String[] arr) {
        for (int current = 0; current < arr.length; current++) {
            int minIndex = current;
            for (int i=current;i<arr.length;i++) {
                if (arr[i].compareTo(arr[minIndex]) < 0)
                    minIndex = i;
            }
            swap(arr, minIndex, current);
        }
    }
}
