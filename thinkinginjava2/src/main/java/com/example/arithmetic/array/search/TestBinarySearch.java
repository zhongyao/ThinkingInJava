package com.example.arithmetic.array.search;

/**
 * 查找
 */
public class TestBinarySearch {

    /**
     * 二分查找【在有序数组中查找某一特定元素】：
     * @param a 有序数组
     * @param key 要查找的值
     * @return index
     *
     * 时间复杂度为:O(log n)
     * 空间复杂度:O(1)
     */
    public static int binarySearch(int a[], int key) {
        int low = 0;
        int high = a.length - 1;
        while (low <= high) {
            //二分查找中的中间值【算法：mid = (low + high) / 2 存在溢出的风险】
            int mid = low  + (high - low) / 2;
            if (a[mid] > key) {
                high = mid - 1;
            } else if (a[mid] < key) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
