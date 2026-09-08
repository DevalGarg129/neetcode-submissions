class Solution {
    public int[][] dirs = {{1,0}, {0,1}, {-1,0}, {0,-1}};

    public class Pair{
        int row;
        int col;

        public Pair(int row, int col){
            this.row = row;
            this.col = col;
        }
    }

    public void bfs(int[][] heights, boolean[][] visited, Queue<Pair> queue){
        while(!queue.isEmpty()){
            Pair curr = queue.poll();

            int row = curr.row;
            int col = curr.col;

            for(int[] dir : dirs){
                int nr = row + dir[0];
                int nc = col + dir[1];
                if(nr < 0 || nc < 0 || nr >= heights.length || nc >= heights[0].length){
                    continue;
                }

                if(visited[nr][nc]){
                    continue;
                }

                if(heights[nr][nc] < heights[row][col]){
                    continue;
                }

                visited[nr][nc] = true;
                queue.add(new Pair(nr, nc));
            }
        }
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> list = new ArrayList<>();

        int n = heights.length;
        int m = heights[0].length;

        boolean[][] pacific = new boolean[n][m];
        boolean[][] atlantic = new boolean[n][m];

        Queue<Pair> pacificQueue = new LinkedList<>();
        Queue<Pair> atlanticQueue = new LinkedList<>();

         // Pacific: top row
        for (int j = 0; j < m; j++) {
            pacific[0][j] = true;
            pacificQueue.add(new Pair(0, j));
        }

        // Pacific: left column
        for (int i = 0; i < n; i++) {
            pacific[i][0] = true;
            pacificQueue.add(new Pair(i, 0));
        }

        // Atlantic: bottom row
        for (int j = 0; j < m; j++) {
            atlantic[n - 1][j] = true;
            atlanticQueue.add(new Pair(n - 1, j));
        }

        // Atlantic: right column
        for (int i = 0; i < n; i++) {
            atlantic[i][m - 1] = true;
            atlanticQueue.add(new Pair(i, m - 1));
        }

        bfs(heights, pacific, pacificQueue);
        bfs(heights, atlantic, atlanticQueue);

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(pacific[i][j] && atlantic[i][j]){
                    list.add(Arrays.asList(i, j));
                }
            }
        }
        return list;
    }
}
