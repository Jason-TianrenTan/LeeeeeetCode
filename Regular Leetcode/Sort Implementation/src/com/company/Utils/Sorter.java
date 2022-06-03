package com.company.Utils;

public abstract class Sorter {

    public abstract void sort(String[] arr);

    public void swap(String[] arr, int x, int y) {
        String temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}
