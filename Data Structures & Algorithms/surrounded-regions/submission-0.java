class Solution {
    public void dfs(char[][] board, int i, int j){
        if(i < 0 || j < 0  || i >= board.length || j >= board[0].length || board[i][j] != 'O'){
            return;
        }
        board[i][j] = 'x';
        dfs(board, i+1, j);
        dfs(board, i-1, j);
        dfs(board, i, j-1);
        dfs(board, i, j+1);
    }
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        for(int r = 0; r < n; r++){
            if(board[r][0] == 'O'){
                dfs(board, r, 0);
            }
            if(board[r][m-1] == 'O'){
                dfs(board, r, m-1);
            }
        }

        for(int c = 0; c < m; c++){
            if(board[0][c] == 'O'){
                dfs(board, 0, c);
            }
            if(board[n-1][c] == 'O'){
                dfs(board, n-1, c);
            }
        }

        for(int r = 0; r < n; r++){
            for(int c = 0; c < m; c++){
                if(board[r][c] == 'O'){
                    board[r][c] = 'X';
                }else if(board[r][c] == 'x'){
                    board[r][c] = 'O';
                }
            }
        }
    }
}
