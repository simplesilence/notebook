package com.shaun.data_structure_algorithm.leetcode;

import java.util.Arrays;

public class LeetCode {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sumsOfTwoNumbers(new int[]{1, 7, 2, 12}, 9)));
    }

    /**
     * 获取数组中两个数相加等于目标值的下标
     * @param array
     * @param target
     * @return
     */
    public static int[] sumsOfTwoNumbers(int[] array, int target){

        int n = array.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if(array[i] + array[j] == target){
                    return new int[]{i, j};
                }
            }
        }

        return null;
    }
}
