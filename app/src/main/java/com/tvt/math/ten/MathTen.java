package com.tvt.math.ten;

import java.util.Arrays;

/**
 *
 */
class MathTen {

    MathTen() {
    }

    public static class ListNode {
        ListNode(int val) {
            this.val = val;
        }

        int val;
        ListNode next;
    }

    public int Fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        int pre2 = 0, pre1 = 1;
        int fib = 0;
        for (int i = 2; i <= n; i++) {
            fib = pre2 + pre1;
            pre2 = pre1;
            pre1 = fib;
        }
        return fib;
    }

    public int RectCover(int n) {
        if (n <= 2) {
            return n;
        }
        int pre2 = 1, pre1 = 2;
        int result = 0;
        for (int i = 3; i <= n; i++) {
            result = pre2 + pre1;
            pre2 = pre1;
            pre1 = result;
        }
        return result;
    }

    public int JumpFloor(int n) {
        if (n <= 2) {
            return n;
        }
        int pre2 = 1, pre1 = 2;
        int result = 1;
        for (int i = 2; i < n; i++) {
            result = pre2 + pre1;
            pre2 = pre1;
            pre1 = result;
        }
        return result;
    }

    public int JumpFloorII(int target) {
        int[] dp = new int[target];
        Arrays.fill(dp, 1);
        for (int i = 1; i < target; i++)
            for (int j = 0; j < i; j++)
                dp[i] += dp[j];
        return dp[target - 1];
    }

    public int JumpFloorIII(int target) {
        return (int) Math.pow(2, target - 1);
    }

}
