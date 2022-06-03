package com.company.Utils;

public class HeapSorter extends Sorter {

    @Override
    public void sort(String[] arr) {
        HeapSort(arr);
    }

    private void HeapSort(String[] arr) {
        int n = arr.length;
        //heapify first, create a max heap
        //start from 0 -> n/2-1; start from 1->n/2
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, i, n);
        //extract minimum
        for (int i=n-1;i>0;i--) {
            swap(arr, i, 0);//now the largest number is at the bottom of the tree arr[i]
            heapify(arr, 0, i);
        }
    }

    private void heapify(String[] arr, int index, int heapSize) {
        int left = 2 * index + 1, right = 2 * index + 2;
        int max = index;
        if (left < heapSize && arr[left].compareTo(arr[max]) > 0)
            max = left;
        if (right < heapSize && arr[right].compareTo(arr[max]) > 0)
            max = right;
        swap(arr, max, index);
        if (max != index)
            heapify(arr, max, heapSize);//max now holds the previous value of arr[index]
    }
}
