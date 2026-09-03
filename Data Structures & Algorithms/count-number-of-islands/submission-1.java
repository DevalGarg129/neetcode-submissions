class Solution {
    public void dfs(char[][] grid, int i, int j){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0'){
            return;
        }
        grid[i][j] = '0';
        //Directions
        dfs(grid, i-1, j); //up
        dfs(grid, i+1, j); //down
        dfs(grid, i, j-1); //left
        dfs(grid, i, j+1); //right
    }
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int count = 0;

        for(int r = 0; r < n; r++){
            for(int c = 0; c < m; c++){
                if(grid[r][c] == '1'){
                    count++;
                    dfs(grid, r, c);
                }
            }
        }
        return count;
    }
}
