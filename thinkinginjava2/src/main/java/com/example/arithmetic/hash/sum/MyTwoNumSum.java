package com.example.arithmetic.hash.sum;

import java.util.HashMap;
import java.util.Map;

/**
 * 【算法】两数之和
 */
public class MyTwoNumSum {

    /**
     * 给定一个整数数组和一个目标值，找出组中和为目标值的两个数的位置。
     * 你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
     * <p>
     * 方法一>>>>暴力法：
     * 时间复杂度：O(n2)
     * 空间复杂度：O(1)
     * @param numbs
     * @param target
     * @return
     */
    public static int[] twoSum(int[] numbs, int target) {
        for (int i = 0; i < numbs.length; i++) {
            for (int j = i + 1; j < numbs.length; j++) {
                if (numbs[i] + numbs[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("参数有误");
    }

    /**
     * 方法2：一遍哈希表
     * 在进行迭代并将元素插入到表中的同时，我们还会回过头来检查表中是否已经存在当前元素所对应的目标元素。
     * 如果它存在，那我们已经找到了对应解，并立即将其返回。
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param numbs
     * @param target
     * @return
     */
    public static int[] twoSumUseHashMap(int[] numbs, int target) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < numbs.length; i++) {
            int temp = target - numbs[i];
            if (hashMap.containsKey(temp)) {
                return new int[]{hashMap.get(temp), i};
            }
            hashMap.put(numbs[i], i);
        }
        throw new IllegalArgumentException("参数有误");
    }
}
