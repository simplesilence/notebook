package com.shaun.data_structure_algorithm.leetcode;

/**
 * 罗马数字转整数
 */
public class LeetCode3 {


    public static void main(String[] args) {

        System.out.println(solution("III"));
    }


    private static int solution(String str){

        int sum = 0;
        int preNum = getValue(str.charAt(0));
        for (int i=1; i<str.length(); i++){
            int num = getValue(str.charAt(i));
            if(preNum < num) sum -= preNum;
            else sum += preNum;
            preNum = num;
        }

        return sum + preNum;
    }

    private static int getValue(char ch){
        switch (ch){
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
}
