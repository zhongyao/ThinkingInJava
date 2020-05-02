package com.example.arithmetic.array;

import java.lang.reflect.Array;
import java.util.Arrays;

public class TestArray {
    public static void main(String[] args) {

        /**
         * 合并两个有序数组,合并后的数组依然是有序的
         */
        int[] array1 = {2, 4, 6, 10,122};
        int[] array2 = {3, 5, 7, 8, 9,22,33,90};
        int[] array = mergeOrderArrays(array1, array2);
        System.out.println("length:" + array.length + " array:" + Arrays.toString(array));
    }

    private static int[] mergeOrderArrays(int[] array1, int[] array2) {
        //两个数组的length中取一个最小的值
        int minLength = Math.min(array1.length, array2.length);
        //合并之后的数组长度
        int totalLength = array1.length + array2.length;
        int i = 0;
        int j = 0;
        int[] array = new int[totalLength];
        while (i < array1.length && j < array2.length) {
            if (array1[i] <= array2[j]) {
                /**
                 * 判断i是否是该数组最后一个index:
                 * 如果不是，则继续走原有逻辑(i++)
                 * 如果是，则走新逻辑【将最后一个值赋值给新数组，然后将array2中的剩余都放到新数组中】
                 */

                if (i == array1.length - 1) {
                    array[i + j] = array1[i];
                    for (; j <= array2.length - 1; j++) {
                        array[i + j + 1] = array2[j];
                    }
                    break;
                } else {
                    array[i + j] = array1[i++];
                }
            } else {
                if (j == array2.length - 1) {
                    array[i + j] = array2[j];
                    for (; i <= array1.length - 1; i++) {
                        array[i + j + 1] = array1[i];
                    }
                    break;
                } else {
                    array[i + j] = array2[j++];
                }
            }
        }
        return array;

    }
}
