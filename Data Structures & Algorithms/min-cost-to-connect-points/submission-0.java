class Solution {
    class Pair{
        int dist;
        int x;
        int y;
        public Pair(int dist, int x, int y){
            this.dist = dist;
            this.x = x;
            this.y = y;
        }
    }
    int[] Parent, Size;

    public void makeSet(int n){
        Parent = new int[n+1];
        Size = new int[n+1];
        for(int i = 0; i <= n; i++){
            Parent[i] = i;
        }
        Arrays.fill(Size, 1);
    }

    public int find(int node){
        if(Parent[node] != node){
            Parent[node] = find(Parent[node]);
        }
        return Parent[node];
    }

    public boolean union(int u, int v){
        int pu = find(u);
        int pv = find(v);
        if(pu == pv) return false;
        if(Size[pu] < Size[pv]){
            int temp = pu;
            pu = pv;
            pv = temp;
        }
        Size[pu] += Size[pv];
        Parent[pv] = pu;
        return true;
    }

    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        makeSet(n);

        ArrayList<Pair> edges = new ArrayList<>();
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                int distance = 
                    Math.abs(points[i][0] - points[j][0]) + 
                    Math.abs(points[i][1] - points[j][1]);
                edges.add(new Pair(distance, i, j));
            }
        }

        edges.sort((a, b) -> Integer.compare(a.dist, b.dist));

        int totalCost = 0;
        int edgesUsed = 0;

        for(Pair edge: edges){
            if(union(edge.x, edge.y)){
                totalCost += edge.dist;
                edgesUsed++;

                if(edgesUsed == n-1){
                    break;
                }
            }
        }
        return totalCost;
    }
}
