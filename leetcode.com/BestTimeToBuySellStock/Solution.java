public class Solution {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }        

        int profit = 0;
        int minSoFar = prices[0];
        for (int i = 1; i < prices.length; ++i) {
            if (prices[i] < minSoFar) {
                minSoFar = prices[i];
            }
            profit = Math.max(profit, prices[i] - minSoFar);
        }        

        return profit;
    }

}