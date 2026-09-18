/**
 * 
 * 力扣198题，打家劫舍
 * 
 * 动态规划
 * 
 */


class Solution {
    /**
    //状态表示：f[i]表示偷到i位置，g[i]表示i位置不偷，此时的最大金额
    //转移方程：dp[i] = 
    如果i位置偷,f[i] = nums[i] + g[i-1];
    如果i位置不偷：g[i] = max(f[i-1],g[i-1]);

    初始化：f[0] = nums[0];
        g[0] = 0;

    填表顺序：从左往右

    返回值：max(f[n-1],g[n-1]);
    
     */
    public int rob(int[] nums) {
        int n = nums.length;
        int[] f = new int[n];
        int[] g = new int[n];
        f[0] = nums[0];
        for(int i=1;i<n;i++){
            f[i] = nums[i] + g[i-1];
            g[i] = Math.max(f[i-1],g[i-1]);
        }
        return Math.max(f[n-1],g[n-1]);
    }
}