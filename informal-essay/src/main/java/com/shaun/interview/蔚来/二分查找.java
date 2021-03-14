package com.shaun.interview.蔚来;

import java.util.ArrayList;
import java.util.List;

/**
 * 使用二分查找的方式来定位某一元素
 */
public class 二分查找 {

    public int search(List<Integer> listA, int keyword) {
        int startNo = 0;
        int endNo = listA.size() - 1;
        while (startNo < endNo) {
            int middleNo = (startNo + endNo) >>> 1;
            if (keyword == listA.get(middleNo)) {
                return middleNo;
            } else if (keyword < listA.get(middleNo)) {
                endNo = middleNo - 1;
            } else {
                startNo = middleNo + 1;
            }
        }
        return -1;
    }


    /**
     * 二分查找的意思是找给定元素在一个有序集合中的下标
     * 基本思路就是分治思想
     * 基于我之前的递归写法，在写一次，上面是网上给出的例子
     * @param elements 在这个集合中查找
     * @param key 要找的元素
     * @param low 分治的开始索引
     * @param high 分治的结束索引
     * @return
     */
    public static int binarySearch(List<Integer> elements, Integer key, int low, int high){
        // 如果起始索引大于结束索引，则未找到，直接返回-1
        if(low > high) return -1;

        // 计算出中间索引
        int mid = (high - low) / 2 + low;

        if(elements.get(mid) > key) return binarySearch(elements, key, low, mid-1);
        else if(elements.get(mid) < key) return binarySearch(elements, key, mid+1, high);
        else return mid;
    }


    public static void main(String[] args) {

        List<Integer> integers = new ArrayList<>();
        integers.add(2);
        integers.add(22);
        integers.add(24);
        integers.add(56);
        integers.add(72);
        integers.add(99);

        System.out.println(binarySearch(integers, 22, 0, integers.size() - 1));
    }




}





