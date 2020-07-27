package com.shaun.data_structure_algorithm.myself;

import java.util.Arrays;

/**
 * 复习直接插入排序算法
 */
public class StraightSort {

    public static void main(String[] args) {

        int[] arr = {3, 0, 13, 4, 5, 9};

        System.out.println(Arrays.toString(sort(arr, arr.length)));
    }

    /**
     *
     * 插入排序的思想
     *  取数组中的第一个值为基准值，该值默认为排好序的区间，剩下的为未排序区间
     *  依次取出未排序区间的值和已排序区间（从后往前对比）
     *      前提：对比到下标一定要大于等于0
     *      如果已排序区间的值大于对比值，则排序区间向后移一位，依次比较，直到已排序区间条件为假
     *      否则，排序区间值等于当前值
     *
     * @param arr 需要排序的数组
     * @param len 数据的长度
     */
    public static int[] sort(int[] arr, int len){

        int i, j, temp;
        // 从第二个值开始对比
        for (i = 1; i < len; i++) {

            temp = arr[i];
            for (j = i-1; j >=0 && arr[j]>temp; j--) {
                arr[j+1] = arr[j];
            }
            arr[j+1] = temp;
        }

        return arr;
    }

}
