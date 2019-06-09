package com.example.arithmetic.sort;

/**
 * Created by zhongyao on 2019-06-09.
 */
public class TestSort {

    private int[] array = {32, 43, 23, 13, 5, 20};

    public static void main(String[] args) {
        /**
         * 最终排序结果应为：5 13 20 23 32 43
         */
        int[] array = {32, 43, 23, 13, 5, 20};

        /**
         * 冒泡排序
         *
         * 最好的时间复杂度：
         * O(n)
         *
         * 最坏时间复杂度为：
         * O(n2)
         *
         * 平均时间复杂度：
         * O(n2)
         *
         */
        int[] resultArray = testBubbleSort(array);
        print(resultArray);
    }

    private static int[] testBubbleSort(int[] array) {

        int temp;

        /**
         * 外层控制循环多少趟
         * 内层控制每一趟循环次数
         */
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }

        return array;
    }

    private static void print(int[] array) {
        System.out.println("最终排序结果为：");
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
