package com.example.arithmetic.sum;

import java.util.HashMap;

/**
 * 求和算法
 */
public class SumTest {


    private static int num1, num2;

    public static void main(String[] args) {

        /**
         * 给定一个整形数组和目标值，找出数组中和为目标值的两个数
         */
        int[] numArray = {2, 11, 15, 4, 6, 7};
        int targetNum = 9;
        doSum(numArray, targetNum);

        doSum2(numArray, targetNum);
    }

    private static void doSum(int[] numArray, int targetNum) {
        for (int i = 0; i < numArray.length - 1; i++) {
            for (int j = i + 1; j < numArray.length; j++) {
                int tempNum = numArray[i] + numArray[j];
                if (tempNum == targetNum) {
                    num1 = numArray[i];
                    num2 = numArray[j];
                    break;
                }
            }
        }
        System.out.println("num1:" + num1 + " num2:" + num2);
    }

    private static void doSum2(int[] numArray, int targetNum) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < numArray.length; i++) {
            hashMap.put(i, numArray[i]);
        }

        for (int i = 0; i < hashMap.size(); i++) {
            int element = targetNum - hashMap.get(i);
            if (hashMap.containsValue(element) && element != hashMap.get(i)) {
                num1 = hashMap.get(i);
                num2 = element;
                break;
            }
        }
        System.out.println("num1:" + num1 + " num2:" + num2);
    }
}
