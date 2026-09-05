class Solution {
    public int[][] dirs = {
        {0,1},
        {1,0},
        {-1,0},
        {0,-1}
    };

    public class Pair{
        int row;
        int col;

        public Pair(int row, int col){
            this.row = row;
            this.col = col;
        }
    }

    public int bfs(int[][] grid, int x, int y){
        Queue<Pair> queue = new LinkedList<>();

        grid[x][y] = 0;
        queue.add(new Pair(x, y));
        int area = 0;

        while(!queue.isEmpty()){
            Pair curr = queue.poll();
            int r = curr.row;
            int c = curr.col;

            area++;

            for(int[] dir : dirs){
                int newRow = r + dir[0];
                int newCol = c + dir[1];

                if(newRow >= 0 && newCol >= 0 && newRow < grid.length && newCol < grid[0].length && grid[newRow][newCol] == 1){
                    grid[newRow][newCol] = 0; //mark new one as visited
                    queue.add(new Pair(newRow, newCol));
                }
            }
        }
        return area;
    }
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int maxArea = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1){
                    int area = bfs(grid, i, j);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }
}
