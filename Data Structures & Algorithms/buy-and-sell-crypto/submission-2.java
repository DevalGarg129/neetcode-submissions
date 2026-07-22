class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int maxProfit = 0;

        int left = 0;
        int right = 1;

        while(right < n){
            if(prices[left] < prices[right]){
                int profit = prices[right] - prices[left];
                maxProfit = Math.max(maxProfit, profit);
            }else{
                left = right;
            }
            right++;
        }

        return maxProfit;
    }
}
