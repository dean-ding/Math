package com.tvt.math.m15;

/**
 * 二进制中 1 的个数
 */
public class Math15 {

    public int NumberOf1(int n) {
        int cnt = 0;
        while (n != 0) {
            cnt++;
            n &= (n - 1);
        }
        return cnt;
    }

    public int NumberOf1WithLeft(int n) {
        int cnt = 0;
        int flag = 1;
        while (flag <= n) {
            if ((flag & n) == flag) {
                cnt++;
            }
            flag = flag << 1;// 左移一位
        }
        return cnt;
    }

}
