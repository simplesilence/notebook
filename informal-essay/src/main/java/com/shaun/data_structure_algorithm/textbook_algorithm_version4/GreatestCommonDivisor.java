package com.shaun.data_structure_algorithm.textbook_algorithm_version4;

/**
 * 参考算法第四版
 * https://book.douban.com/subject/19952400/
 */
public class GreatestCommonDivisor {

    public static void main(String[] args) {

        System.out.println(method(15, 158790));
    }

    /**
     * 求p，q的最大公约数
     * 如果q是0，最大公约数就是p
     * 如果
     */
    public static int method(int p, int q) {
        if (q == 0) return p;
        int r = p % q;
        return method(q, r);
    }
}
