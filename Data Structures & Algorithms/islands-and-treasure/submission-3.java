class Solution {
    class Pair{
        int row;
        int col;

        public Pair(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
    
    public void islandsAndTreasure(int[][] grid) {
        Queue<Pair> queue = new LinkedList<>();

        int m = grid.length;
        int n = grid[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 0){
                    queue.add(new Pair(i, j));
                }
            }
        }
        if(queue.size() == 0) return;
        int[][] dirs = {{-1,0}, {1,0}, {0,1}, {0,-1}};

        while(!queue.isEmpty()){
            Pair curr = queue.poll();

            int row = curr.row;
            int col = curr.col;

            for(int[] dir : dirs){
                int r = row + dir[0];
                int c = col + dir[1];
                if(r >= m || c >= n || c < 0 || r < 0 || grid[r][c] != Integer.MAX_VALUE){
                    continue;
                }
                queue.add(new Pair(r, c));
                grid[r][c] = grid[row][col] + 1;
            }
        }
    }
}
