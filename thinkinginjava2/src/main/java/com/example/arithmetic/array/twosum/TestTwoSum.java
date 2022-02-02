package com.example.arithmetic.array.twosum;

import com.example.arithmetic.sort.TestSort;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那两个整数，并返回它们的数组下标。
 * 【假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。】
 */
public class TestTwoSum {
    /**
     * 方法一【推荐】：
     * 借助于HashMap,key放当前的值【如nums[i]】,value放当前的索引【i】,直至target - nums[i]对应的key有相应的值【i】
     *
     * @return
     */
    public static int[] twoSum_One(int[] nums, int target) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.get(target - nums[i]) != null) {
                return new int[]{hashMap.get(target - nums[i]), i};
            }
            hashMap.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }

    /**
     * 方法二：
     * 暴力法--双重循环
     *
     * @return
     */
    public static int[] twoSum_Two(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }


    /**
     * 方法三【不推荐 -- 涉及到排序及新老数据的index切换】：
     * 1、先对数组进行排序
     * 2、先取头部第一个【i == 0】跟尾部最后一个【j == num.length - 1】相加，判断是否等于target，如果等于判断结束
     * 3、如果小于则i++ ;如果大于则j--，直至i==j
     */
    public static int[] twoSum_Three(int[] nums, int[] newNums, int target) {
        TestSort.testBubbleSort(newNums);
        for (int i = 0; i < newNums.length; i++) {
            for (int j = newNums.length - 1; j < newNums.length; j--) {
                if (i == j) {
                    return new int[]{-1, -1};
                }
                if (newNums[i] + newNums[j] == target) {
                    int tempI = -1, tempJ = -1;
                    for (int k = 0; k < nums.length; k++) {
                        if (nums[k] == newNums[i]) {
                            tempI = k;
                        }
                        if (nums[k] == newNums[j]) {
                            tempJ = k;
                        }
                    }
                    return new int[]{tempI, tempJ};
                } else if (newNums[i] + newNums[j] < target) {
                    break;
                }
            }
        }
        return new int[]{-1, -1};
    }


}
