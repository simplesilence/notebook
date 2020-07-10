package com.shaun.data_structure_algorithm.textbook_algorithm_version4.myself;

public class 回文 {

    public static void main(String[] args) {

        System.out.println(test("21346546"));
        System.out.println(test("上海自来水来自海上"));
    }


    public static boolean test(String str){

        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) != str.charAt(str.length()-1-i)){
                return false;
            }
        }
        return true;
    }
}
