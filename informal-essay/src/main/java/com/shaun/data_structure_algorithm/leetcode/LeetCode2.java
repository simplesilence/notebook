package com.shaun.data_structure_algorithm.leetcode;

/**
 * 整数反转
 * 整数回文
 */
public class LeetCode2 {

    public static void main(String[] args) {

        System.out.println(LeetCode2.reverse(123));

        System.out.println(LeetCode2.isPalindrome(12321));
    }


    public static int reverse(int num){

        int rev = 0;

        while (num != 0){

            // 每次弹出最后一位
            int pop = num % 10;

            // 除以10获取除掉最后一位的数字，如123/10 = 12，便于下一次弹出最后一位2
            num /= 10;

            // 避免溢出
            if(rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if(rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;

            // 翻转数字
            rev = rev * 10 + pop;
        }

        return rev;
    }

    /**
     * 判断数字是否回文
     * @return
     */
    public static boolean isPalindrome(int x){

        // 负数、以0结尾（不包括0）的数字绝对不是回文
        if(x < 0 || (0 == x % 10 && x != 0)) return false;

        int revertedNumber = 0;
        // 原始值大于翻转值，可继续翻转，否则已到达中位数
        while (x > revertedNumber){
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }

        return x == revertedNumber || x == revertedNumber / 10;
    }
}
