package com.tvt.math.five;

/**
 * 替换空格
 * 时间复杂度为O(n)
 */
class MathFive {

    MathFive() {
    }

    String replaceSpace(StringBuffer str) {
        // 避免空指针
        if (str == null) {
            return "";
        }
        int P1 = str.length() - 1;
        // 遍历字符串存在多少个空格，计算出需要增加的长度
        for (int i = 0; i <= P1; i++)
            if (str.charAt(i) == ' ') {
                str.append("  ");// 添加两个空格用来插入%20
            }
        // 从后面往前面插入，相比于从前面往后减少字符串的重复移动，做到时间复杂度为O(N)
        int P2 = str.length() - 1;
        while (P1 >= 0 && P2 > P1) {
            char c = str.charAt(P1--);
            if (c == ' ') {
                str.setCharAt(P2--, '0');
                str.setCharAt(P2--, '2');
                str.setCharAt(P2--, '%');
            }
            else {
                str.setCharAt(P2--, c);
            }
        }
        return str.toString();
    }

}
