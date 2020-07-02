package com.tvt.math.m20;

/**
 * <p><strong>表示数值的字符串</strong></p>
 */
public class Math20 {
    /**
     * <p>[]  ： 字符集合</p>
     * <p>()  ： 分组</p>
     * <p>?   ： 重复 0 ~ 1 次</p>
     * <p>+   ： 重复 1 ~ n 次</p>
     * <p>*   ： 重复 0 ~ n 次</p>
     * <p>.   ： 任意字符</p>
     * <p>\\. ： 转义后的 .</p>
     * <p>\\d ： 数字</p>
     */
    public boolean isNumeric(char[] str) {
        if (str == null || str.length == 0) {
            return false;
        }
        return new String(str).matches("[+-]?\\d*(\\.\\d+)?([eE][+-]?\\d+)?");
    }

}
