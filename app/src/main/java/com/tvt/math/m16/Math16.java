package com.tvt.math.m16;

/**
 * <p><strong>数值的整数次方</strong></p>
 * <p>给定一个 double 类型的浮点数 base 和 int 类型的整数 exponent(整数/负数)，求 base 的 exponent 次方</p>
 * <p>2的32次方=2的16次方*2的16次方，以此为思路优化计算次数</p>
 */
public class Math16 {

    public double Power(double base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        if (exponent == 1) {
            return base;
        }
        boolean isNegative = false;
        if (exponent < 0) {
            exponent = -exponent;
            isNegative = true;
        }
        double pow = Power(base * base, exponent / 2);
        if (exponent % 2 != 0) {
            pow = pow * base;
        }
        return isNegative ? 1 / pow : pow;
    }

}
