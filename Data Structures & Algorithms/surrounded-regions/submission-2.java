class Solution {
    public class Pair{
        int row;
        int col;
        public Pair(int row, int col){
            this.row = row;
            this.col = col;
        }
    }

    private int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};

    public void bfs(char[][] board){
        int n = board.length;
        int m = board[0].length;
        Queue<Pair> q = new LinkedList<>();
        for(int r = 0; r < board.length; r++){
            for(int c = 0; c < board[0].length; c++){
                if((r == 0 || r == n - 1 || c == 0 || c == m - 1) && board[r][c] == 'O'){
                    q.offer(new Pair(r, c));
                    board[r][c] = '#';
                }
            }
        }

        while(!q.isEmpty()){
            Pair curr = q.poll();
            int r = curr.row;
            int c = curr.col;

            for(int[] dir : dirs){
                int nr = r + dir[0];
                int nc = c + dir[1];
                if(nr >= 0 && nc >= 0 && nr < n && nc < m && board[nr][nc] == 'O'){
                    board[nr][nc] = '#';
                    q.offer(new Pair(nr, nc));
                }
            }
        }
    }
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        bfs(board);
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }else if(board[i][j] == '#'){
                    board[i][j] = 'O';
                }
            }
        }
    }
}
