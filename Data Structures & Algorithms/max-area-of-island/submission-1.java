class Solution {
    public int dfs(int[][] grid, int x, int y){
        if(x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == 0){
            return 0;
        }
        grid[x][y] = 0;

        int right = dfs(grid, x+1, y);
        int left = dfs(grid, x-1, y);
        
        int down = dfs(grid, x, y+1);
        int up = dfs(grid, x, y-1);

        return 1 + left + right + up + down;
    }
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int maxArea = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
               int area = dfs(grid, i, j);

               maxArea = Math.max(maxArea, area);
            }
        }
        return maxArea;
    }
}
