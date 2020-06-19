package com.tvt.math.three;

/**
 * 数组中重复的数字
 * 空间复杂度为O(1),时间复杂度为O(N)
 * 传入数组中的数字不能大于等于数组的长度
 */
class MathThree {

    private int[] numbers;

    MathThree(int[] numbers) {
        this.numbers = numbers;
    }

    void count() {
        int[] duplication = new int[1];
        boolean result = duplicate(numbers, numbers.length, duplication);
        System.out.println(result + "---------->" + duplication[0]);
    }

    private boolean duplicate(int[] numbers, int length, int[] duplication) {
        if (numbers == null || length <= 0) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            if (numbers[i] >= length) {
                System.err.println("有不符合要求的数字");
                return false;
            }
        }
        for (int i = 0; i < length; i++) {
            while (numbers[i] != i) {
                if (numbers[i] == numbers[numbers[i]]) {
                    duplication[0] = numbers[i];
                    return true;
                }
                swap(numbers, i, numbers[i]);
            }
        }
        return false;
    }

    private void swap(int[] numbers, int i, int j) {
        int t = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = t;
    }

}
