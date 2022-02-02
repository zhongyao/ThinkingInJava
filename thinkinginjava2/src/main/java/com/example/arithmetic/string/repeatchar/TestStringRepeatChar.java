package com.example.arithmetic.string.repeatchar;

import java.util.HashSet;
import java.util.Set;

/**
 * 判断一个字符串中是否有重复字符
 */
public class TestStringRepeatChar {

    /**
     * 方法一：
     * 暴力法 -- 双重循环
     *
     * @param str
     * @return
     */
    public static boolean hasRepeatChar_One(String str) {
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length - 1; i++) {
            for (int j = i + 1; j < chars.length; j++) {
                if (chars[i] == chars[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 方法二：
     * 使用str.indexOf()与str.lastIndexOf()是否相等 来判断
     *
     * @param str
     * @return
     */
    public static boolean hasRepeatChar_Two(String str) {
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (str.indexOf(chars[i]) != str.lastIndexOf(chars[i])) {
                return true;
            }
        }
        return false;
    }

    /**
     * 方法三：
     * 使用HashSet辅助实现
     */
    public static boolean hasRepeatChar_Three(String str) {
        Set<Character> hashSet = new HashSet<>();
        char[] chars = str.toCharArray();
        for (char s: chars) {
            if (hashSet.contains(s)) {
                return true;
            }
            hashSet.add(s);
        }
        return false;
    }

    /**
     * 方法四：
     * 跟方法三类似 只不过这里是比较size
     */
    public static boolean hasRepeatChar_Four(String str) {
        Set<Character> hashSet = new HashSet<>();
        char[] chars = str.toCharArray();
        for (char s: chars) {
            hashSet.add(s);
        }
        return !(hashSet.size() == chars.length);
    }
}
