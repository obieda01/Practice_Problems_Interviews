class Solution {
    public void solve(char[][] board) {
        int r = board.length;
        int c = board[0].length;

        for(int i = 0; i < c; i++){
            if(board[0][i] == 'O') dfs(board, 0, i);
            if(board[r-1][i] == 'O') dfs(board, r -1, i);
        }
        for(int i = 0; i < r; i++){
            if(board[i][0] == 'O') dfs(board, i, 0);
            if(board[i][c-1] == 'O') dfs(board, i, c-1);
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X'; // 2) Capture surrounded regions (O -> X)
                if (board[i][j] == 'T') board[i][j] = 'O'; // 3) Uncapture unsurrounded regions (T- O)
            }
        }

    }
        private void dfs(char[][] board, int r, int c) {
        int nRows = board.length;
        int nCols = board[0].length;
        if (
            r < 0 || c < 0 || r >= nRows || c >= nCols || board[r][c] != 'O'
        ) return;
        board[r][c] = 'T';
        dfs(board, r + 1, c);
        dfs(board, r - 1, c);
        dfs(board, r, c + 1);
        dfs(board, r, c - 1);         
        }
}