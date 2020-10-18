package com.shaun.data_structure_algorithm.myself;

/**
 * 插入排序
 */
public class InsertionSort {

    public static void main(String[] args) {
        InsertionSort insertionSort = new InsertionSort();
        insertionSort.insertionSort(new int[]{5,2,6,9,0,3});
    }

    public void insertionSort(int[] arr){

        int len = arr.length;
        if(len <= 1){
            return;
        }

        for (int i = 1; i < len; i++) {

            int current = arr[i];

            int preIndex = i - 1;

            while (preIndex >= 0 && arr[preIndex] > current){

                arr[preIndex + 1] = arr[preIndex];
                preIndex--;
            }
            arr[preIndex + 1] = current;
        }
    }
}
