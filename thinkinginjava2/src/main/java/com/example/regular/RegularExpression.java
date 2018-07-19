package com.example.regular;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author zhongyao
 * @date 2018/7/12
 * 正则表达式
 * 参考：https://www.cnblogs.com/shuqi/p/4427693.html
 */

public class RegularExpression {
    private static String text = "this  is text";
    /**
     * \s+ 可以匹配多个空格
     */
    private static String textRegular = "this\\s+is\\s+text";

    private static String text2 = "3.2";

    private static String textRegular2 = "^\\d+(\\.\\d+)?";

    private static String content = "I am noob " +
        "from runoob.com.";

    private static String pattern = ".*runoob.*";

    public static void main(String[] args) {
        boolean isMatched = Pattern.matches(textRegular, text);
        System.out.println("isMatched:" + isMatched);

        boolean isMatched2 = Pattern.matches(textRegular2, text2);
        System.out.println("isMatched2:" + isMatched2);

        boolean isMatched3 = Pattern.matches(pattern, content);
        System.out.println("isMatched3:" + isMatched3);

        //以空格分割
        String str1 = "1 2 3          4 54       5 6";
        String[] numbers = str1.split(" +");
        for (String temp : numbers) {
            System.out.println(temp);
        }

        // 替换，替换所有的数字为*
        String str2 = "abd123:adad46587:asdadasadsfgi#%^^9090";
        System.out.println(str2.replaceAll("[0-9]", "*"));
        // \d 数字：[0-9]
        System.out.println(str2.replaceAll("\\d", "*"));

        /**
         * \w 单词字符：[a-zA-Z_0-9]
         *
         * X{n,m} X，至少 n 次，但是不超过 m 次
         */
        // 匹配匹配邮箱
        String mail1 = "ababc@asa.com";
        String mail2 = "ababc@asa.com.cn";
        String mail3 = "ababc@asa";
        //        String mainRegex = "[0-9a-zA-Z_]+@[0-9a-zA-Z_]++(\\.[0-9a-zA-Z_]+{2,4})+";
        String mainRegex = "\\w+@\\w+(\\.\\w{2,4})+";

        //true
        System.out.println(mail1.matches(mainRegex));
        //true
        System.out.println(mail2.matches(mainRegex));
        //false
        System.out.println(mail3.matches(mainRegex));

        /**
         * 第一种使用场景：仅仅使用Matcher对象来匹配想要的字符串
         *
         * \b 单词边界， 就是不是单词字符的地方。
         * \w 单词字符：[a-zA-Z_0-9]
         * X{n} X，恰好 n 次
         *
         * boolean 　  matcher.find() //查找下一个匹配对象
         * matcher.group() //返回整个匹配模式匹配到的结果
         */

        // 匹配出3个字符的字符串
        String str
            = "abc 124 ewqeq qeqe   qeqe   qeqe  aaaa  fs fsdfs d    sf sf sf  sf sfada dss dee ad a f s f sa a'lfsd;"
            + "'l";
        Pattern pt = Pattern.compile("\\b\\w{3}\\b");
        Matcher match = pt.matcher(str);
        while (match.find()) {
            System.out.println(match.group());
        }

        // 匹配出邮箱地址
        String str22
            = "dadaadad   da da   dasK[PWEOO-123- DASJAD@DHSJK.COM DADA@DAD.CN =0KFPOS9IR23J0IS ADHAJ@565@ADA.COM.CN "
            + "shuqi@162.com UFSFJSFI-SI- ";
        Pattern pet2 = Pattern.compile("\\b\\w+@\\w+(\\.\\w{2,4})+\\b");
        Matcher match2 = pet2.matcher(str22);
        while (match2.find()) {
            System.out.println(match2.group());
        }

        /**
         * 第二种使用场景：匹配规则中包含匹配组，要求匹配得到相应的匹配组的数据：
         */
        String sr = "dada ada adad adsda ad asdda adr3 fas daf fas fdsf 234 adda";
        //包含两个匹配组，一个是三个字符，一个是匹配四个字符
        Pattern pet = Pattern.compile("\\b(\\w{3}) *(\\w{4})\\b");
        Matcher match22 = pet.matcher(sr);
        int countAll = match22.groupCount();//2
        while (match22.find()) {
            System.out.print("匹配组结果：");
            for (int i = 0; i < countAll; i++) {
                System.out.print(String.format("\n\t第%s组的结果是:%s", i + 1, match22.group(i + 1)));
            }
            System.out.print("\n匹配的整个结果:");
            System.out.println(match22.group());
        }

        /**
         *  . 任何字符
         *  * 匹配前面的子表达式零次或多次。
         *  + 匹配前面的子表达式一次或多次。+ 等价于 {1,}。
         *
         */
        //String pattern = "(?s).*((＄|＄)(.+?)(＄|＄))(?s).*";
        //String pattern = "(?s).*((＄)(.+?)(＄))(?s).*";
        //String pattern = ".*((＄)(.+?)(＄)).*";
        String pattern = ".*((＄|¥)(.+)(＄|¥)).*";

        //String strings = "复制这条信息＄tIahbaSKyRc＄后打开APP【立即打开】";
        String strings = "复制这条信息¥tIahbaSKyRc¥后打开APP【立即打开】";
        boolean isMatchedU = Pattern.matches(pattern, strings);
        System.out.println("isMatchedU：" + isMatchedU);

    }

}
