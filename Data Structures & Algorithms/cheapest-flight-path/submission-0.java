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

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(src, 0, 0));

        int[] minCost = new int[n];
        Arrays.fill(minCost, Integer.MAX_VALUE);

        minCost[src] = 0;

        while(!queue.isEmpty()){
            Pair curr = queue.poll();
            int city = curr.city;
            int cost = curr.cost;
            int stops = curr.stops;

            if(stops > k){
                continue;
            }

            for(Pair flight : list.get(city)){
                int newCost = cost + flight.cost;
                int newStops = stops + 1;

                if(newCost < minCost[flight.city]){
                    minCost[flight.city] = newCost;
                    queue.add(new Pair(flight.city, newCost, newStops));
                }
            }
        }
        return minCost[dst] == Integer.MAX_VALUE ? -1 : minCost[dst];
    }
}
