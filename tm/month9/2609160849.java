/**
 * 力扣121：买卖股票的最佳时机
 * 简单
 * 
 */


class Solution {
    public int maxProfit(int[] prices) {
        //只需要维护一个最小值
        int min = prices[0];
        int n = prices.length;
        int ans = 0;
        for(int i= 1;i<n;i++){
            min = Math.min(min,prices[i]);
            ans = Math.max(ans,prices[i] - min);
        }
        return ans;
    }
}