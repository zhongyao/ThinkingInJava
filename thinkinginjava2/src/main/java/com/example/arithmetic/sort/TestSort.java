package com.example.arithmetic.sort;

/**
 * Created by zhongyao on 2019-06-09.
 * 参考：
 * http://ju.outofmemory.cn/entry/372908
 */
public class TestSort {

    public static void main(String[] args) {
        /**
         * 最终排序结果应为：5 13 20 22 28 43
         */
        int[] array = {22, 43, 28, 13, 5, 20};
        int[] sortedArray;

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
         * 空间复杂度为常量【即temp变量需要的内存空间】：
         * O(1)
         *
         */
        //sortedArray = testBubbleSort(array);
        //print(sortedArray);

        /**
         * 快速排序(冒泡排序的一种改进)：
         * 通过一趟划分将要排序序列分割成独立的三个部分：
         * 左部、基准值、右部
         * 其中左部所有的数据都比基准值小，右部所有数据都比基准值大，然后再按此方法分别对左部和右部再进行划分。
         *
         */
        sortedArray = testFastSort(array, 0, array.length - 1);
        print(sortedArray);

    }

    /**
     *
     * @param array 待排序数组
     * @param low 左边界
     * @param high 右边界
     * @return
     */
    private static int[] testFastSort(int[] array, int low, int high) {
        if (array == null || array.length <= 0) {
            return null;
        }

        if (low >= high) {
            return null;
        }

        int left = low;
        int right = high;
        int temp = array[left];

        while (left < right) {
            while (left < right && array[right] >= temp) {
                right--;
            }
            array[left] = array[right];

            while (left < right && array[left] <= temp) {
                left++;
            }
            array[right] = array[left];
        }

        array[left] = temp;
        testFastSort(array, low, left - 1);
        testFastSort(array, left + 1, high);

        return array;
    }

    private static int[] testBubbleSort(int[] array) {

        int temp;

        /**
         * 外层控制循环多少趟
         * 内层控制每一趟循环次数
         */
        //需要length-1次循环比较
        for (int i = 0; i < array.length - 1; i++) {
            //内层：每次循环需要两两比较的次数，每次比较后，都会将当前最大的数放到最后位置，所以每次比较次数递减一次
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

        if (array == null) {
            System.out.print("数组为null");
        }
        System.out.println("最终排序结果为：");
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
