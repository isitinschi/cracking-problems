public class Solution {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }        

        int profit = 0;
        for (int i = 1; i < prices.length; ++i) {
            profit += Math.max(0, prices[i] - prices[i - 1]);
        }      

        return profit;
    }
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.maxProfit(new int [] {1,2,3,4,5,1,2,3,4,5}));
	}

}