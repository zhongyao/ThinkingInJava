package com.example.arithmetic.string;

import java.util.HashSet;
import java.util.Set;

public class TestString {
    public static void main(String[] args) {
        /**
         * 无重复字符的最长字符串：
         *
         * 给定一个字符串，找出不含有重复字符的最长子串的长度
         */
        //result： fetgra 长度为6
        String string = "effetgraorogee";
        int resultLength = doString(string);
        System.out.println("resultLength:" + resultLength);
    }

    private static int doString(String string) {
        int n = string.length();
        int resultLength = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (judgeResult(string, i, j)) {
                    resultLength = Math.max(resultLength, j - i);
                    System.out.println("resultLength---:" + resultLength);
                }
            }
        }
        return resultLength;
    }

    private static boolean judgeResult(String string, int begin, int end) {
        Set<Character> chr = new HashSet<>();
        for (int i = begin; i < end; i++) {
            Character charStr = string.charAt(i);
            if (chr.contains(charStr)) {
                return false;
            } else {
                chr.add(charStr);
            }
        }

        System.out.println(chr.toString());
        return true;
    }
}
