class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length; 
        int cols = heights[0].length;
        boolean[][] pac = new boolean[rows][cols];
        boolean[][] atl = new boolean[rows][cols];
        List<List<Integer>> res = new ArrayList<>();
        for(int r = 0; r < rows; r++){
            dfs(pac, r, 0, Integer.MIN_VALUE, heights);
            dfs(atl, r, cols - 1, Integer.MIN_VALUE, heights);

        }
        
        for(int c = 0; c < cols; c++){
            dfs(pac, 0, c, Integer.MIN_VALUE, heights);
            dfs(atl, rows - 1, c,Integer.MIN_VALUE, heights);
        }
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){{
                    if(pac[i][j] && atl[i][j]){
                        List<Integer> list = new ArrayList<>();
                        list.add(i);
                        list.add(j);
                        res.add(list);
                    }

                }
            }
        }
        return res;
    }

    public void dfs(boolean[][] visited, int r, int c, int prev, int[][] heights){
        if(r < 0 || r >= heights.length || c < 0 || c >= heights[0].length||
        prev > heights[r][c] || visited[r][c]){
            return;
        }

        visited[r][c] = true;
        dfs(visited, r + 1, c, heights[r][c], heights);
        dfs(visited, r - 1, c, heights[r][c], heights);
        dfs(visited, r, c + 1, heights[r][c], heights);
        dfs(visited, r, c - 1, heights[r][c], heights);
        return;
       
    }
}