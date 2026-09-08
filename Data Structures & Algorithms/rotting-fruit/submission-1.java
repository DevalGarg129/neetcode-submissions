class Solution {
    public int[][] dirs = {{0,1}, {1,0}, {-1,0}, {0,-1}};
    class Pair{
        int row;
        int col;

        public Pair(int row, int col){
            this.row = row;
            this.col = col;
        }
    }

    public int Bfs(int[][] grid, int x, int y){
        Queue<Pair> queue = new LinkedList<>();

        int fresh = 0;

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 2){
                    queue.add(new Pair(i, j));
                }
                if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }
        int minutes = 0;
        while(!queue.isEmpty() && fresh > 0){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                Pair curr = queue.poll();
                int row = curr.row;
                int col = curr.col;

                for(int[] dir : dirs){
                    int nr = row + dir[0];
                    int nc = col + dir[1];

                    if(nr >= 0 && nc >= 0 && nr < grid.length && nc < grid[0].length && grid[nr][nc] == 1){
                        grid[nr][nc] = 2;
                        fresh--;
                        queue.add(new Pair(nr, nc));
                    }
                }
            }
            minutes++;
        }
        if(fresh > 0){
            return -1;
        }
        return minutes;
    }
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        return Bfs(grid, 0, 0);
    }
}
