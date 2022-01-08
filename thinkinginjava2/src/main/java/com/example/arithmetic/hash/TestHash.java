package com.example.arithmetic.hash;

import com.example.arithmetic.hash.sum.MyTwoNumSum;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class TestHash {
    public static void main(String[] args) {
        /**
         * 只出现一次的数字：
         * 给定一个非空整形数组，除了某个元素只出现一次以外，其他的元素均出现两次。找出那个出现了一次的元素。
         *
         * 思路1---使用两个栈来实现：
         * 1、将单个元素逐个开始放入stack1中；
         * 2、在放入之前，需先判断一下stack1中是否有该元素；
         * 3、如果没有，则正常放入stack1中；
         * 4、如果有，则将该元素放置stack2中，所以最终stack2中的元素均是重复的元素值。
         * 5、遍历数组元素实在在stack2中,最终不在stack2中的那个元素，即是只出现一次的数字..
         */
        int[] array = {4, 1, 2, 1, 2, 3, 3, 5, 5};
        int resultNum = findOnceElement(array);
        System.out.println("resultNum: " + resultNum);
        /**
         * 思路2---使用Set来实现：
         * 1、遍历数组，将每个元素add至Set中；
         * 2、由于Set中不可以有重复元素，所以当Set中已经有该元素的时候，会add失败；
         * 3、此时，顺便将之前存储的该元素移除；
         * 4、最终Set中存储的元素，值剩一个只出现一次的数字。
         * 5、从Set中取出即可。
         */
        int resultNum2 = findOnceElement2(array);
        System.out.println("resultNum2: " + resultNum2);


        /**
         * 存在重复元素：
         * 给定一个整形数组，判断是否存在重复元素
         */
        int[] a = {4, 1, 2, 3, 5, 7, 8, 89, 40};
        boolean result = judgeRepeatedNum(a);
        System.out.println("有重复元素: " + result);


        /**
         * 字符串中的第一个唯一字符：
         * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引，如果不存在则返回-1.
         * 【只包含小写字母】
         *
         * 思路：
         * 1、创建一个list集合和黑名单blackList集合，将字符串中的每一个字符，从头开始add至list中，前提是黑名单blackList中不存在该元素且list中不存在该元素。
         * 2、如果list中已包含该元素，则证明该元素重复，将该字符从list中移除,并将该字符添加到黑名单blackList中。
         * 3、依次类推，只有字符串唯一字符，会被add值list中。
         * 4、取第一个字符即是所找的字符。
         * 5、通过s.indexOf("所找字符")返回索引即可
         */
        String s = "allooveJJaammeess";
        char[] charArray = s.toCharArray();
        findFirstSingleChar(s, charArray);


        /**
         * 给定一种'pattern（模式）'和一个字符串'str'，判断字符串'str'是否遵循相同的模式：
         * 这里的遵循指完全匹配，例如：'pattern'里的每个字母和字符串'str'中的每个非空单词之间存在着对应的模式。
         *
         * 示例：
         * 输入pattern = "aabba", str = "dog dog cat cat dog"  返回true
         * 输入pattern = "aabba", str = "dog dog cat dog dog"  返回false
         *
         * 说明：
         * 可以假设"pattern"只包含小写字母，"str"包含了由单个空格分隔的小写字母。
         *
         * 思路：
         * 1、将pattern转成字符串数组(即每个元素只包含一个字符)
         * 2、将str转成字符串数组(即每个元素是一个字符串【单词】)
         * 3、判断两者length是否相等，如果不等直接返回false
         * 4、然后逐步从头开始将pattern的每个index索引对应的元素作为key，将str的每个index索引对应的元素作为value【如果有重复以第一个为准】，存至Map中(如果没有map中无此key的话)。
         * 如果有，那么会将此时此value跟map中对应key的value进行对比，如果不相同则返回false。直至最后，如果没毛病，则返回true。
         *
         */
        String pattern = "abbaa";
        String str = "dog cat cat cat dog";

        boolean flag = judgePattern(pattern, str);
        System.out.println("flag:" + flag);


        /**
         * 两个数组的交集（1）：
         * 给定两个数组，写一个函数来计算他们的交集。
         * 提示：在结果中的每个元素必定是唯一的；可以不用考虑输出顺序
         * 如 arrayA = [1,2,2,1]  arrayB = [2,2]  输出[2]
         *
         * 思路：
         * 1、对arrayA进行遍历，从index=0开始如果arrayB中包含arrayA[0]
         * 2、那么将此元素，放置新数组C中[准备放入C的时刻，需要保证C中无此元素]；如果不包含，那么继续遍历index=1
         * 3、依次类推
         */

        Integer[] arrayA = {1, 2, 2, 1};
        Integer[] arrayB = {2, 2};
        intersection1(arrayA, arrayB);

        /**
         * 给定两个数组（2）：
         * 给定两个数组，写一个方法来计算他们的交集。
         * 提示：输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
         * 如 arrayA = [1,2,2,1]  arrayB = [2,2]  输出[2,2]
         *
         * 思路：
         * 1、对arrayB进行遍历，从index=0开始如果arrayA中包含arrayB[0]
         * 2、那么将此元素，放置新数组C中，同时将arrayA中的此元素删除。
         * 3、依次类推。
         */

        Integer[] arrayAA = {1, 2, 2, 1};
        Integer[] arrayBB = {2, 2};
        intersection2(arrayAA, arrayBB);

        /**
         * 【算法】两数之和
         */
        int[] numbs = new int[]{2, 7, 11, 15};
        int target = 9;
//        int[] c = MyTwoNumSum.twoSum(numbs, target);
        int[] c = MyTwoNumSum.twoSumUseHashMap(numbs, target);
        System.out.println("c:" + Arrays.toString(c));

    }

    private static void intersection2(Integer[] arrayA, Integer[] arrayB) {
        List<Integer> listA = new ArrayList<>(Arrays.asList(arrayA));
        List<Integer> listB = new ArrayList<>(Arrays.asList(arrayB));
        List<Integer> resultList = new ArrayList<>();
        for (int i = 0; i < listB.size(); i++) {
            Integer element = listB.get(i);
            if (listA.contains(element)) {
                resultList.add(element);
                listA.remove(element);
            }
        }

        System.out.println("resultList2:" + resultList);
    }

    private static void intersection1(Integer[] arrayA, Integer[] arrayB) {
        List<Integer> listA = Arrays.asList(arrayA);
        List<Integer> listB = Arrays.asList(arrayB);
        List<Integer> resultList = new ArrayList<>();
        for (int i = 0; i < listA.size(); i++) {
            Integer element = listA.get(i);
            if (listB.contains(element) && !resultList.contains(element)) {
                resultList.add(element);
            }
        }

        System.out.println("resultList:" + resultList);
    }

    private static boolean judgePattern(String pattern, String str) {
        char[] patternArray = pattern.toCharArray();
        String[] strArray = str.split(" ");

        if (patternArray.length != strArray.length) {
            return false;
        }
        Map<String, String> hashMap = new HashMap<>();
        for (int i = 0; i < patternArray.length; i++) {
            String key = String.valueOf(patternArray[i]);
            String value = strArray[i];

            if (!hashMap.containsKey(key)) {
                hashMap.put(key, value);
            } else {
                String mapValue = hashMap.get(key);
                if (!mapValue.equals(value)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void findFirstSingleChar(String string, char[] charArray) {
        List<Character> list = new ArrayList<>();
        List<Character> blackList = new ArrayList<>();
        for (char charElement : charArray) {
            if (!blackList.contains(charElement)) {
                if (list.contains(charElement)) {
                    list.remove(Character.valueOf(charElement));
                    blackList.add(charElement);
                } else {
                    list.add(charElement);
                }
            }
        }

        if (list.size() > 0) {
            char resultChar = list.get(0);
            int resultIndex = string.indexOf(resultChar);
            System.out.println("resultChar:" + resultChar + " resultIndex:" + resultIndex);
        } else {
            int resultIndex = -1;
            System.out.println("不存在唯一字符");
        }

        //附加：JAVA有自动提升数据类型的机制,比如int+char结果就是int,int+String结果就是String
        char a = 'a';
        char b = 'b';
        int result = b - a;//结果result为1
    }

    private static boolean judgeRepeatedNum(int[] array) {
        if (array == null || array.length == 0) {
            return false;
        }

        Set<Integer> set = new HashSet<>();
        for (int element : array) {
            if (!set.add(element)) {
                return true;
            }
        }
        return false;
    }

    private static int findOnceElement2(int[] array) {
        Set<Integer> set = new HashSet<>();
        int resultNum;
        for (int element : array) {
            if (!set.add(element)) {
                set.remove(element);
            }
        }

        Iterator<Integer> iterator = set.iterator();
        resultNum = iterator.next();

        return resultNum;
    }

    private static int findOnceElement(int[] array) {

        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        int resultNum = 0;

        for (int value : array) {
            if (!stack1.contains(value)) {
                stack1.push(value);
            } else {
                stack2.push(value);
            }
        }

        for (int value : array) {
            if (!stack2.contains(value)) {
                resultNum = value;
            }
        }

        return resultNum;
    }
}
