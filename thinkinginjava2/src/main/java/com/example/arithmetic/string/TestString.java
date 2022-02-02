package com.example.arithmetic.string;

import com.example.arithmetic.string.repeatchar.TestStringRepeatChar;

import java.util.HashSet;
import java.util.Set;

public class TestString {
    public static void main(String[] args) {
        /**
         * 判断一个字符串中是否有重复字符
         */
        String str = "zxmnlkbcdaefga";
        long beginTime = System.nanoTime();
        boolean hasRepeat = TestStringRepeatChar.hasRepeatChar_Four(str);
        long endTime = System.nanoTime();
        System.out.println("hasRepeat:" + hasRepeat + " spendTime:" + (endTime - beginTime));


        /**
         * 无重复字符的最长字符串：
         *
         * 给定一个字符串，找出不含有重复字符的最长子串的长度
         */
        //result： fetgra 长度为6
        String string = "effetgraorogee";
        //时间复杂度o3
//        int resultLength = doString(string);
//        System.out.println("resultLength:" + resultLength);

        int resultLength2 = doString2(string);
        System.out.println("resultLength2:" + resultLength2);
    }

    private static int doString2(String s) {
        Set<Character> set = new HashSet<>();
        int n = s.length();
        int ans = 0;
        int i = 0;
        int j = 0;
        while (i < n && j < n) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
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
