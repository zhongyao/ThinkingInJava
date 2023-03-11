package com.example.arithmetic.sort;

/**
 * Created by zhongyao on 2019-06-09.
 * 参考：
 * http://ju.outofmemory.cn/entry/372908
 */
public class TestSort {

    public static void main(String[] args) {
        /**
         * 原数组序列为：   22 43 28 13 5 20
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
         * O(n2) 【n的平方】
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
         * 最好情况下时间复杂度：
         * O(nlogn)
         *
         * 平均时间复杂度：
         * O(nlogn)
         *
         * 最坏时间复杂度：
         * O(n2)【n的平方】
         *
         * 空间复杂度：
         * O(1)
         *
         */
        //sortedArray = testFastSort(array, 0, array.length - 1);
        //print(sortedArray);

        /**
         * 插入排序(基本思想)：
         * 将线性表看出是有序/无序两个部分，有序子表是a[0,i-1],无序子表是a[i,n-1]
         * 排序过程中每次从无序子表中选出一个元素，将其插入到有序子表的正确位置，有序子表保持正确有序并逐渐增大，
         * 直到所有的记录都插入到有序子表为止。
         *
         * 最好时间复杂度：
         * O(n)
         *
         * 平均时间复杂度：
         * O(n2)【n的平方】
         *
         * 最坏时间复杂度：
         * O(n2)
         *
         * 空间复杂度：
         * O(1)
         */
        //sortedArray = testInsertSort(array);
        //print(sortedArray);

        /**
         * 选择排序（基本思想）：
         * 将线性表看成是有序/无序两个部分，有序子表是a[0,i-1],无序子表是a[i,n-1]
         * 排序过程中每次从无序子表中选出最小的一个元素，将其添加到有序子表的末尾，有序子表保持增长并且
         * 长度增加1，无序子表长度减少1，重复这个过程直到无序子表为空。
         */
        //sortedArray = testSelectSort(array);
        //print(sortedArray);

        /**
         * 归并排序：
         * 参考：https://www.cnblogs.com/of-fanruice/p/7678801.html
         *
         */

        sortedArray = mergeSort(array, 0, array.length - 1);
        print(sortedArray);
    }

    private static int[] mergeSort(int[] array, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(array, low, mid);
            mergeSort(array, mid + 1, high);
            merge(array, low, mid, high);
        }
        return array;
    }

    private static void merge(int[] array, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];

        int i = low;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= high) {
            if (array[i] <= array[j]) {
                temp[k++] = array[i++];
            } else {
                temp[k++] = array[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = array[i++];
        }

        while (j <= high) {
            temp[k++] = array[j++];
        }

        for (int x = 0; x < temp.length; x++) {
            array[x + low] = temp[x];
        }
    }

    // 22 43 28 13 5 20
    private static int[] testSelectSort(int[] array) {

        int temp;
        //存放无序子表中最小元素的index
        int jmin = 0;
        //存放无序子表中最小元素的值
        int amin;
        int min = 0;
        for (int i = 0; i < array.length; i++) {
            amin = array[i];
            for (int j = i + 1; j < array.length; j++) {
                //选取无序子表中的最小值
                if (array[j] < amin) {
                    amin = array[j];
                    jmin = j;
                }
            }

            //判断、交换
            if (array[i] > min) {
                temp = array[i];
                array[i] = array[jmin];
                array[jmin] = temp;
            }
        }

        return array;
    }

    private static int[] testInsertSort(int[] array) {
        if (array == null || array.length <= 0) {
            return null;
        }

        int key;
        int temp;
        for (int i = 1; i < array.length; i++) {
            //将进行到的某位置的一个index值保存至key中
            key = i;
            //当前值大于前一个值，那么两者交互，直到后者不大于前者为止
            while (i >= 1 && array[i] < array[i - 1]) {
                temp = array[i - 1];
                array[i - 1] = array[i];
                array[i] = temp;
                i--;
            }
            //将原先保存的index值重新赋给i开始下一轮for循环
            i = key;
        }
        return array;
    }

    /**
     * @param array 待排序数组
     * @param low   左边界
     * @param high  右边界
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

    public static int[] testBubbleSort(int[] array) {
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
