class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int maxArea = 0;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(grid[i][j] == 1){
                    maxArea = Math.max(maxArea, dfs(rows, cols, i, j, grid));
                }
            }
        }
        return maxArea;
    }
    public int dfs(int r, int c, int i, int j, int[][] grid){
        if(i < 0 || i >= r || j < 0 || j >= c || grid[i][j] == 0) return 0;
        grid[i][j] = 0;
        return (1 + dfs(r, c, i, j + 1, grid)
        +dfs(r, c, i + 1, j, grid)
        +dfs(r, c, i - 1, j, grid)
        +dfs(r, c, i, j - 1, grid));
    }
}