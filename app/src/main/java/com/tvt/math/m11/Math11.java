package com.tvt.math.m11;

/**
 * <strong>旋转数组的最小数字</strong>
 *
 * <p>把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素</p>
 */
public class Math11 {

    public int minNumberInRotateArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int l = 0, h = nums.length - 1;
        while (l < h) {
            int m = l + (h - l) / 2;
            // 三个数都相等
            if (nums[l] == nums[m] && nums[m] == nums[h]) {
                // 取出中间最小的一个值
                return minNumber(nums, l, h);
            }
            // 中间值小于等于最后的值
            else if (nums[m] <= nums[h]) {
                h = m;
            }
            // 中间值大于开始的值
            else {
                l = m + 1;
            }
        }
        return nums[l];
    }

    private int minNumber(int[] nums, int l, int h) {
        for (int i = l; i < h; i++)
            if (nums[i] > nums[i + 1]) {
                return nums[i + 1];
            }
        return nums[l];
    }
}
