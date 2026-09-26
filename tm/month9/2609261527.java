/**
 * 
 * 64.最小路径和
 * 动态规划
 * 
 */

class Solution {
    /**
    状态表示：dp[i][j] 表示从起始位置到i，j位置的最小和
    转移方程：dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1])+grid[i][j];
    初始化：第一行，第一类都置为无穷大，dp[0][1] = 0
    填表顺序：左->右 上->下
    返回值：dp[m][n]
     */
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m+1][n+1];
        for(int i =0 ;i<=m;i++){
            dp[i][0] = Integer.MAX_VALUE;
        }
        for(int j =0;j<=n;j++){
            dp[0][j] = Integer.MAX_VALUE;
        }
        dp[0][1] = 0;
        for(int i=1;i<=m;i++){
            for(int j =1;j<=n;j++){
                dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1])+grid[i-1][j-1];
            }
        }
        return dp[m][n];
    }
}