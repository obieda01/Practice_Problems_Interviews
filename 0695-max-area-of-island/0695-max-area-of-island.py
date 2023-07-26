class Solution:
    def maxAreaOfIsland(self, grid: List[List[int]]) -> int:
        row, col, maxArea = len(grid), len(grid[0]), 0
        visited = set()
        def dfs(r, c, grid, visited):
            if( r not in range(row) or c not in range(col)or
                (r,c) in visited or grid[r][c] == 0
            ):
                return 0
            
            visited.add((r, c))
            return (1 + dfs(r + 1, c, grid, visited) + 
            dfs(r - 1, c, grid, visited) +
            dfs(r , c + 1, grid, visited) +
            dfs(r, c - 1, grid, visited))
        
        for r in range(row):
            for c in range(col):
                if grid[r][c] == 1 and (r, c) not in visited:
                    
                    maxArea = max(maxArea, dfs(r,c, grid, visited))
        return maxArea
        
