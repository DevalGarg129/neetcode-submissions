class Solution {
    private class Pair{
        int row;
        int col;
        private Pair(int row, int col){
            this.row = row;
            this.col = col;
        }
    }

    private int[][] dirs = {{0,1}, {1,0}, {0,-1}, {-1,0}};

    public void bfs(char[][] grid, int r, int c){
        Queue<Pair> queue = new LinkedList<>();
        grid[r][c] = '0';
        queue.add(new Pair(r, c));

        while(!queue.isEmpty()){
            Pair curr = queue.remove();
            int row = curr.row;
            int col = curr.col;
            
            for(int[] dir: dirs){
                int newRow = row + dir[0];
                int newCol = col + dir[1];
                if(newRow >= 0 && newCol >= 0 && newRow < grid.length && newCol < grid[0].length && grid[newRow][newCol] == '1'){
                    queue.add(new Pair(newRow, newCol));
                    grid[newRow][newCol] = '0';
                }
            }
        }
    }

    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int count = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == '1'){
                    bfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }
}
