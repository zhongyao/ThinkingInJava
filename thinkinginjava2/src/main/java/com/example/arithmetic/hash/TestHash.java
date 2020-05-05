package com.example.arithmetic.hash;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Stack;

public class TestHash {
    public static void main(String[] args) {
        /**
         * 只出现一次的数字：
         * 给定一个非空整形数组，除了某个元素只出现一次以外，其他的元素均出现两次。找出那个出现了一次的元素。
         *
         * 思路1---使用两个栈来实现：
         * 1、将单个元素逐个开始放入stack1中；
         * 2、在放入之前，需先判断一下stack1中是否有该元素；
         * 3、如果没有，则正常放入stack1中；
         * 4、如果有，则将该元素放置stack2中，所以最终stack2中的元素均是重复的元素值。
         * 5、遍历数组元素实在在stack2中,最终不在stack2中的那个元素，即是只出现一次的数字..
         */
        int[] array = {4, 1, 2, 1, 2, 3, 3, 5, 5};
        int resultNum = findOnceElement(array);
        System.out.println("resultNum: " + resultNum);
        /**
         * 思路2---使用Set来实现：
         * 1、遍历数组，将每个元素add至Set中；
         * 2、由于Set中不可以有重复元素，所以当Set中已经有该元素的时候，会add失败；
         * 3、此时，顺便将之前存储的该元素移除；
         * 4、最终Set中存储的元素，值剩一个只出现一次的数字。
         * 5、从Set中取出即可。
         */
        int resultNum2 = findOnceElement2(array);
        System.out.println("resultNum2: " + resultNum2);


        /**
         * 存在重复元素：
         * 给定一个整形数组，判断是否存在重复元素
         */
        int[] a = {4, 1, 2, 3, 5, 7, 8, 89, 40};
        boolean result = judgeRepeatedNum(a);
        System.out.println("有重复元素: " + result);

    }

    private static boolean judgeRepeatedNum(int[] array) {
        if (array == null || array.length == 0) {
            return false;
        }

        Set<Integer> set = new HashSet<>();
        for (int element : array) {
            if (!set.add(element)) {
                return true;
            }
        }
        return false;
    }

    private static int findOnceElement2(int[] array) {
        Set<Integer> set = new HashSet<>();
        int resultNum;
        for (int element : array) {
            if (!set.add(element)) {
                set.remove(element);
            }
        }

        Iterator<Integer> iterator = set.iterator();
        resultNum = iterator.next();

        return resultNum;
    }

    private static int findOnceElement(int[] array) {

        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        int resultNum = 0;

        for (int value : array) {
            if (!stack1.contains(value)) {
                stack1.push(value);
            } else {
                stack2.push(value);
            }
        }

        for (int value : array) {
            if (!stack2.contains(value)) {
                resultNum = value;
            }
        }

        return resultNum;
    }
}
