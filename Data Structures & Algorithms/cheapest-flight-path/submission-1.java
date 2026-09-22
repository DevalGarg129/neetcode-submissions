class Solution {
    class Pair{
        int city; 
        int cost; 
        int stops; 

        public Pair(int city, int cost, int stops){
            this.city = city;
            this.cost = cost;
            this.stops = stops;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Pair>> list = new ArrayList<>();

        for(int i = 0; i < n; i++){
            list.add(new ArrayList<>());
        }

        for(int[] flight : flights){
            int from = flight[0];
            int to = flight[1];
            int price = flight[2];

            list.get(from).add(new Pair(to, price, 0));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);
        pq.offer(new Pair(src, 0, 0));

        int[][] dist = new int[n][k+2];

        for(int i = 0; i < n; i++){
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        dist[src][0] = 0;
        while(!pq.isEmpty()){
            Pair curr = pq.poll();

            int city = curr.city;
            int cost = curr.cost;
            int stops = curr.stops;

            if(city == dst){
                return cost;
            }

            if(stops > k){
                continue;
            }

            for(Pair edge : list.get(city)){
                int nextCity = edge.city;
                int newCost = cost + edge.cost;
                int newStops = stops + 1;

                if(newCost < dist[nextCity][newStops]){
                    dist[nextCity][newStops] = newCost;
                    pq.offer(new Pair(nextCity, newCost, newStops));
                }
            }
        }
        return -1;
    }
}
