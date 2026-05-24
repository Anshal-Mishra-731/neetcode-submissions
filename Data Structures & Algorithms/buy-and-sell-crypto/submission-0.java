class Solution {
    public int maxProfit(int[] prices) {
        int[] min = new int[prices.length];
        min[0] = prices[0];
        for(int i = 1; i < prices.length; i++){
            min[i] = Math.min(min[i-1], prices[i]);
        }
        int res = 0;
        for(int i = 1; i < prices.length; i++){
            res = Math.max(res, prices[i] - min[i-1]);
        }
        return res;
    }
}