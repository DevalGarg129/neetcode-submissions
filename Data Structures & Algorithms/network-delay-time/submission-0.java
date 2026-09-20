class Solution {
    class Pair{
        int src;
        int target;
        int t;

        public Pair(int src, int target, int t){
            this.src = src;
            this.target = target;
            this.t = t;
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[k-1] = 0;

        for(int i = 0; i < n-1; i++){
            for(int[] time : times){
                Pair edge = new Pair(time[0]-1, time[1]-1, time[2]);

                int u = edge.src;
                int v = edge.target;
                int w = edge.t;

                if(dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v]){
                    dist[v] = dist[u] + w;
                }
            }
        }

        int maxDist = Arrays.stream(dist).max().getAsInt();
        return maxDist == Integer.MAX_VALUE ? -1 : maxDist;
    }
}
