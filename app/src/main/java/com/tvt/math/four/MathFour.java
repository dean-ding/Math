package com.tvt.math.four;

/**
 * 二维数组中的查找
 * 需要从左下角或者右上角查找
 * 时间复杂度 O(M + N)，空间复杂度 O(1)
 */
class MathFour {

    private int[][] matrix;

    MathFour(int[][] matrix) {
        this.matrix = matrix;
    }

    public boolean Find(int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int rows = matrix.length, cols = matrix[0].length;
        int r = 0, c = cols - 1; // 从右上角开始
        while (r <= rows - 1 && c >= 0) {
            if (target == matrix[r][c]) {
                return true;
            }
            else if (target > matrix[r][c]) {
                r++;
            }
            else {
                c--;
            }
        }
        return false;
    }

}
