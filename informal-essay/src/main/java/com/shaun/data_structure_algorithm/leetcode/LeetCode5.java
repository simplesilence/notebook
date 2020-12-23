package com.shaun.data_structure_algorithm.leetcode;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 括号是否合法
 */
public class LeetCode5 {

    public static void main(String[] args) {
        System.out.println(isValid("([{])"));
    }


    public static boolean isValid(String str){

        int len = str.length();
        if(len % 2 == 1) return false;
        Map<Character, Character> map = new HashMap<Character, Character>(){
            {
                put(')', '(');
                put(']', '[');
                put('}', '{');
            }
        };

        Deque<Character> stack = new LinkedList<>();

        for (int i = 0; i < len; i++) {

            char chr = str.charAt(i);
            if(map.containsKey(chr)){

                if(stack.isEmpty() || map.get(chr) != stack.peekFirst()) return false;

                stack.pop();

            }else stack.push(chr);
        }

        return stack.isEmpty();
    }
}
