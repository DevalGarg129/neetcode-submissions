class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int profit = 0;

        for(int i = 0; i < n; i++){
            int buy = prices[i];
            for(int j = i+1; j < n; j++){
                int sell = prices[j];
                profit = Math.max(profit, prices[j] - prices[i]);
            }
        }
        return profit;
    }
}
