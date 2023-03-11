package com.example.arithmetic.string.longsubstr;

import java.util.HashSet;
import java.util.Set;

/**
 * 获取一个字符串中最长的不含重复字符的子字符串，返回该子字符串的长度
 * 如 abcabcbb 返回 3
 */
public class TestLongestSubStr {
    /**
     * 方法一：
     * 双重循环
     */
    public static int longestSubStr_One(String string) {
        char[] chars = string.toCharArray();
        Set<Character> hashSet = new HashSet<>();
        int max = 1;
        int temp = 1;
        for (int i = 0; i < chars.length - 1; i++) {
            hashSet.clear();
            hashSet.add(chars[i]);
            temp = 1;
            for (int j = i + 1; j < chars.length; j++) {
                if (!hashSet.contains(chars[j])) {
                    hashSet.add(chars[j]);
                    temp++;
                    if (temp > max) {
                        max = temp;
                    }
                } else {
                    break;
                }
            }
        }
        return max;
    }

    /**
     * 方法二：
     * 双指针
     */
    public static int longestSubStr_Two(String s) {
        //结果变量
        int result = 0;
        int len = s.length();
        //set集合用来判断子字符串是否包含重复元素
        Set<Character> hashSet = new HashSet<>();
        //j指针即结束位置指针初值应该为0
        int j = 0;
        for (int i = 0; i < len; i++) {
            if (i != 0) {
                //每次遍历新的起始位置，都要把前面的元素从集合中移出。
                hashSet.remove(s.charAt(i - 1));
            }
            //向后移动j指针，直到遇到字符串结尾或者将要包含重复元素为止
            while (j < len && !hashSet.contains(s.charAt(j))) {
                //当添加下一个元素，仍不包含重复元素时，可以添加进行，并把j指针后移
                hashSet.add(s.charAt(j));
                j++;
            }
            //更新结果变量
            result = Math.max(result, j - i);
        }
        return result;
    }
}
