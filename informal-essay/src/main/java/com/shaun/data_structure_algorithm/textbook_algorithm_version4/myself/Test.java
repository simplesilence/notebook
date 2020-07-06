package com.shaun.data_structure_algorithm.textbook_algorithm_version4.myself;

/**
 * 常用小算法
 */
public class Test {

    public static void main(String[] args) {

//        Test test = new Test();
//        test.test2();

//        Byte a = 5;
//        System.out.println(a==5);

        System.out.println(test1(" 1230321  "));
    }

    /**
     * 判断给定的字符串是否是回文
     * @param str 给定的字符串
     * @return
     */
    public static boolean test1(String str){

        if(null != str && !"".equals(str = str.trim())){
            System.out.println(str);
            for (int i = 0; i < str.length()/2; i++) {
                if(str.charAt(i) != str.charAt(str.length()-1-i)){
                    return false;
                }
            }
        }

        return true;
    }

    public void test2(){
        System.out.println(Test.this);
        System.out.println(this);
    }
}
