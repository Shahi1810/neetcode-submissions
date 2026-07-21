class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length == 1) return 0;
        int i = 0, j = 0, maxProfit = 0;
        while(i<prices.length && j<prices.length){
            int profit = prices[j]-prices[i];
            if(profit <= 0){
                i=j;
                profit=0;
            }
            j++;
            maxProfit = Math.max(profit,maxProfit);
        }
        return maxProfit; 
    }
}
