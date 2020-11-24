package com.shaun.data_structure_algorithm.leetcode;

/**
 * 最长公共字符串
 */
public class LeetCode4 {

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        System.out.println(longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
    }

    /**
     * 横向扫描
     * @param str
     * @return
     */
    public static String longestCommonPrefix(String[] str){

        if(null == str || str.length == 0) return "";

        String prefix = str[0];
        int length = str.length;
        for (int i = 1; i < length; i++) {

            prefix = longestCommonPrefix(prefix, str[i]);
            if(prefix.length() == 0) return "";
        }

        return prefix;
    }

    public static String longestCommonPrefix(String str1, String str2){
        int i = 0;
        int length = Math.min(str1.length(), str2.length());
        while (i < length && str1.charAt(i) == str2.charAt(i)){
            i++;
        }

        return str1.substring(0, i);
    }
}
