package com.shaun.data_structure_algorithm.textbook_algorithm_version4.myself;

public class 回文 {

    public static void main(String[] args) {

        System.out.println(palindrome("21346546"));
        System.out.println(palindrome("上海自来水来自海上"));
    }


    /**
     * 两个指针
     *  第一个指针从字符串下标0
     *  第二个指针从字符串下标字符串长度-1
     *  依次对应，第一个指针依次向前，第二个指针依次向后
     * @param str
     * @return
     */
    public static boolean palindrome(String str){

        for (int i = 0; i < str.length(); i++) {
            System.out.println("左："+(int)str.charAt(i)+"\t"+"右："+(int)str.charAt(str.length()-1-i));
            if(str.charAt(i) != str.charAt(str.length()-1-i)) return false;
        }

        return true;
    }
}
