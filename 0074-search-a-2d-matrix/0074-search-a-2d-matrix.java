class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length, cols = matrix[0].length, i = 0, j = cols - 1;
        while (i >= 0 && i < rows && j >= 0 && j < cols) {
            int num = matrix[i][j];
            if (num == target) return true;
            if (num < target) i++;
            else j--;
        }
        return false;
    }
}