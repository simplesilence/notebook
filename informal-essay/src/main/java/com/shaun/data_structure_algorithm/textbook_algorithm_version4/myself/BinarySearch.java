package com.shaun.data_structure_algorithm.textbook_algorithm_version4.myself;

/**
 * binary search
 */
public class BinarySearch {

    public static void main(String[] args) {

        int[] a = {1,4,5,8,11,13,91,97,100};
        System.out.println(rank(a, 0, 0, a.length-1));
    }

    /*
     * 分支查找思想
     * 把带有下标的的数组排序
     * 如果lo > hi说明没找到
     * 找到中间下标，根据数组长度找到中间的下标，(hi-lo)/2-lo
     * 判断中间下标的值是否大于，小于，等于给定的值
     *      大于：说明在数组的左侧，lo不变，hi=mid-1
     *      小于：说明在数组的右侧，lo=mid+1，hi不变
     *      等于：mid下标所对应的值就是当前给定的值
     */
    public static int rank(int[] arr, int key, int low, int high){

        if(low > high) return -1;

        int mid = (high-low) / 2 + low;

        if(arr[mid] > key) return rank(arr, key, low, mid-1);
        else if(arr[mid] < key) return rank(arr, key, mid+1, high);
        else return mid;

    }
}
