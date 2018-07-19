package com.example;

/**
 * @author zhongyao
 * @date 2018/7/16
 *
 * 位运算符:
 * &
 * |
 * ~
 */

public class BitwiseOperators {

    /**
     * 10
     */
    public static final int REQUEST_BLOCK_THUMBNAIL = 1 << 1;

    /**
     * 100
     */
    public static final int REQUEST_BLOCK_SHAREKEY = 1 << 2;

    /**
     * 1000
     */
    public static final int REQUEST_BLOCK_IMAGE = 1 << 3;

    /**
     * 10000
     */
    public static final int REQUEST_IMAGE = 1 << 4;

    /**
     * 100000
     */
    public static final int REQUEST_MINIPROGRAM_BLOCK_THUMBNAIL = 1 << 5;

    public static int type = 0;

    public static String binaryType;

    public static int mCurrentBlockRequestType = 0;

    public static void main(String[] args) {
        /**
         * 101110
         */
        type = REQUEST_BLOCK_THUMBNAIL | REQUEST_BLOCK_SHAREKEY | REQUEST_BLOCK_IMAGE
            | REQUEST_MINIPROGRAM_BLOCK_THUMBNAIL;

        /**
         * 将十进制数字转换成二进制
         */
        binaryType = Integer.toBinaryString(type);

        System.out.println("type:" + type);
        System.out.println("binaryType:" + binaryType);

        System.out.println("REQUEST_BLOCK_THUMBNAIL:" + REQUEST_BLOCK_THUMBNAIL);

        if ((type & REQUEST_BLOCK_THUMBNAIL) != 0) {
            System.out.println("have:REQUEST_BLOCK_THUMBNAIL");
        }
        if ((type & REQUEST_BLOCK_SHAREKEY) != 0) {
            mCurrentBlockRequestType |= REQUEST_BLOCK_SHAREKEY;
            System.out.println("have:REQUEST_BLOCK_SHAREKEY");
        }
        if ((type & REQUEST_BLOCK_IMAGE) != 0) {
            mCurrentBlockRequestType |= REQUEST_BLOCK_IMAGE;
            System.out.println("have:REQUEST_BLOCK_IMAGE");
        }
        if ((type & REQUEST_MINIPROGRAM_BLOCK_THUMBNAIL) != 0) {
            System.out.println("have:REQUEST_MINIPROGRAM_BLOCK_THUMBNAIL");
        }

        /**
         * 100
         *
         * mCurrentBlockRequestType:1100
         */
        onBlockRequestFinish(REQUEST_BLOCK_SHAREKEY);

        /**
         * 1000
         *
         * mCurrentBlockRequestType:1000
         */
        onBlockRequestFinish(REQUEST_BLOCK_IMAGE);

        onBlockRequestFinish(REQUEST_BLOCK_THUMBNAIL);

    }

    private static void onBlockRequestFinish(int requestType) {
        mCurrentBlockRequestType &= ~requestType;
        System.out.println("mCurrentBlockRequestType:" + Integer.toBinaryString(mCurrentBlockRequestType));
        if (mCurrentBlockRequestType == 0) {
            System.out.println("所有阻塞性的网络请求已完成");
        }
    }
}
