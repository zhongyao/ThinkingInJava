package com.example;

import static java.lang.System.out;

/**
 * @author zhongyao
 * @date 2018/1/16
 */

public class Chapter7ReusingClass {
    private static String mTemplateText = "哈哈哈哈$$呵呵呵呵";
    private static String middleText = "$jidjifdjf$";
    private String value1, value2;
    private static int counter = 0;
    //private WaterSource source = new WaterSource();
    private int i;
    private float f;

    /**
     * 1、每个非基本类型的对象都有一个toString()方法，而且当编译器需要一个String而你却只有一个对象时，该方法便会被调用。
     * 2、类中域为基本类型时能够自动初始化为零，但是对象引用会被初始化为null
     *
     * @return
     */

    public static void main(String[] args) {

        out.println(mTemplateText.substring(0, mTemplateText.indexOf("$"))+middleText + mTemplateText.substring(mTemplateText.lastIndexOf("$")+1, mTemplateText.length()));

        out.println(mTemplateText.length());
        mTemplateText = mTemplateText.replaceAll("$", "");

        for (int i = 0; i < mTemplateText.length(); i++) {
            mTemplateText.contains("$");
        }
        out.println(mTemplateText);
        //out.println(mTemplateText.length() -.length());

        String str1 = "哈哈哈哈0$0$00$呵呵呵呵";
        String str2 = "$";
        int i = countStr(str1, str2);
        System.out.println("i---------->" + i);

    }

    /**
     * 判断str1中包含str2的个数
     *
     * @param str1
     * @param str2
     * @return counter
     */
    public static int countStr(String str1, String str2) {
        if (str1.indexOf(str2) == -1) {
            return 0;
        } else if (str1.indexOf(str2) != -1) {
            counter++;
            countStr(str1.substring(str1.indexOf(str2) +
                str2.length()), str2);
            return counter;
        }
        return 0;

    }

    //class WaterSource {
    //    private String s;
    //
    //    public WaterSource() {
    //        out.println("WaterSource");
    //        s = "Constructed";
    //    }
    //
    //    @Override
    //    public String toString() {
    //        return s;
    //    }
    //}

}