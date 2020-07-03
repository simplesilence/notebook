package com.shaun.data_structure_algorithm.textbook_algorithm_version4;

/**
 * 二分查找的递归实现
 */
public class BinarySearch {

    public static void main(String[] args) {

        int[] a = {1, 4,5,8,11,13,91,97,100};
        System.out.println(rank(13, a, 0, a.length-1));
    }


    /**
     * 二分查找
     * @param key 需要查找的数
     * @param a 在数组中查找
     * @param lo 左侧指针游标
     * @param hi 右侧指针游标
     * @return
     */
    public static int rank(int key, int[] a, int lo, int hi) {

        // 如果lo > hi，没找到return -1
        if(lo > hi) return -1;
        // 找出二分位
        int mid = (hi - lo) / 2 + lo;
        if(a[mid] > key) return rank(key, a, lo, mid - 1);
        else if(a[mid] < key) return rank(key, a, mid + 1, hi);
        else return mid;
    }
}
