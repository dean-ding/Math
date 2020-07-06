package com.tvt.math.m21;

/**
 * 调整数组顺序使奇数位于偶数前面
 */
public class Math21 {

    // 创建一个新数组，时间复杂度 O(N)，空间复杂度 O(N)。
    public void reOrderArray1(int[] nums) {
        // 奇数个数
        int oddCnt = 0;
        for (int x : nums)
            if (!isEven(x)) {
                oddCnt++;
            }
        int[] copy = nums.clone();
        int i = 0, j = oddCnt;
        for (int num : copy) {
            if (num % 2 == 1) {
                nums[i++] = num;
            }
            else {
                nums[j++] = num;
            }
        }
    }

    private boolean isEven(int x) {
        return x % 2 == 0;
    }

    // 使用冒泡思想，每次都当前偶数上浮到当前最右边。时间复杂度 O(N<sup>2</sup>)，空间复杂度 O(1)，时间换空间。
    public void reOrderArray2(int[] nums) {
        int N = nums.length;
        for (int i = N - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (isEven(nums[j]) && !isEven(nums[j + 1])) {
                    swap(nums, j, j + 1);
                }
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

}
