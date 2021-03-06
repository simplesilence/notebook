package com.shaun.data_structure_algorithm.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 */
public class LeetCode1 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sumOfTwoNumbers1(new int[]{1, 7, 2, 12}, 9)));
        System.out.println(Arrays.toString(sumOfTwoNumbers2(new int[]{1, 7, 2, 12}, 9)));
    }

    /**
     * 获取数组中两个数相加等于目标值的下标
     * TODO 时间复杂度O(N2)，暴力枚举
     * @param array
     * @param target
     * @return
     */
    public static int[] sumOfTwoNumbers1(int[] array, int target){

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

    /**
     * hash方法
     * 思路：
     *      1、把目标值减去当前值，得到需要的值，看是否在hash表中
     *          不在，将当前下标的值放入hash表
     *          在，直接返回当前hash表中的值和当前值
     * @param nums
     * @param target
     * @return
     */
    public static int[] sumOfTwoNumbers2(int[] nums, int target){

        // 借助hash表
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {

            // 查看hash表是否存在目标值-当前值的差
            if(hashMap.containsKey(target - nums[i])){
                return new int[]{i, hashMap.get(target - nums[i])};
            }

            // 出入当前值以及索引
            hashMap.put(nums[i], i);
        }

        return null;
    }
}
