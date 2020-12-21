package com.example.arithmetic.array;

import com.example.arithmetic.array.search.TestBinarySearch;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Stack;

public class TestArray {
    public static void main(String[] args) {

        /**
         * 合并两个有序数组,合并后的数组依然是有序的
         */
        int[] array1 = {2, 4, 6, 10, 122};
        int[] array2 = {3, 5, 7, 8, 9, 22, 33, 90};
        int[] array = mergeOrderArrays(array1, array2);
        System.out.println("length:" + array.length + " array:" + Arrays.toString(array));


        /**
         * 删除排序数组中的重复项
         */
        int[] orderArray = {1, 3, 5, 5, 7, 8, 8, 9, 90, 90};
        //result:1, 3, 5, 7, 8, 9, 90
        deleteOrderedArrayRepeat(orderArray);

        //方法2：
        deleteOrderedArrayRepeat2(orderArray);

        /**
         * 二分查找
         */
        int[] a = {1, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59};
        int key = 37;
        int index = TestBinarySearch.binarySearch(a, key);
        System.out.println("index:" + index);
    }

    /**
     * 思路：
     * 1、将数组中没有出现过的数字，根据索引先后一个个插入到现有数组中，并计数，最后根据计数值取前几位的数组，就是新的结果数组。
     *
     * @param orderArray
     */
    private static void deleteOrderedArrayRepeat2(int[] orderArray) {
        int i = 0;
        for (int j = 1; j < orderArray.length; j++) {
            if (orderArray[i] != orderArray[j]) {
                i++;
                orderArray[i] = orderArray[j];
            }
        }
        int[] resultArray = Arrays.copyOfRange(orderArray, 0, i + 1);
        System.out.println("方法2：" + Arrays.toString(resultArray));
    }

    /**
     * 步骤：
     * 1、从头开始，将不重复的元素放置栈中。
     * 2、然后根据栈中的元素个数，定义一个同样长度的新数组。将出栈的第一个元素放置新数组的末尾，... ，
     * 最后一个出栈的一个元素放置新数组的首位即可
     *
     * @param orderArray
     */
    private static void deleteOrderedArrayRepeat(int[] orderArray) {
        Stack<Integer> tempStack = new Stack<>();
        for (int i = 0; i < orderArray.length; i++) {
            if (!tempStack.contains(orderArray[i])) {
                tempStack.push(orderArray[i]);
            }
        }

        int resultSize = tempStack.size();
        int[] resultArray = new int[resultSize];
        for (int i = 0; i < resultSize; i++) {
            resultArray[resultSize - 1 - i] = tempStack.pop();
        }

        System.out.println(Arrays.toString(resultArray));

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
