package com.tvt.math.m17;

/**
 * <p><strong>打印从 1 到最大的 n 位数</strong></p>
 * <p>输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数即 999。</p>
 * <p>由于 n 可能会非常大，因此不能直接用 int 表示数字，而是用 char 数组进行存储。</p>
 */
public class Math17 {

    public void print1ToMaxOfNDigits(int n) {
        if (n <= 0) {
            return;
        }
        char[] number = new char[n];
        long time = System.currentTimeMillis();
        print1ToMaxOfNDigits(number, 0);
        System.out.println("计算所需时间：" + (System.currentTimeMillis() - time));
    }

    private void print1ToMaxOfNDigits(char[] number, int digit) {
        if (digit == number.length) {
            printNumber(number);
            return;
        }
        for (int i = 0; i < 10; i++) {
            number[digit] = (char) (i + '0');
            print1ToMaxOfNDigits(number, digit + 1);
        }

    }

    //打印速度很慢，虽然循环减少了次数
    /*private void printNumber(char[] number) {
        int index = 0;
        StringBuilder builder = new StringBuilder(number.length);
        boolean print = false;
        while (index < number.length) {
            if (number[index] != '0') {
                print = true;
            }
            if (print) {
                builder.append(number[index]);
            }
            index++;
        }
    }*/

    private void printNumber(char[] number) {
        int index = 0;
        while (index < number.length && number[index] == '0')
            index++;
        while (index < number.length) {
            System.out.print(number[index++]);
        }
        System.out.println();
    }
}
