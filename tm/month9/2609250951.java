/**
 * 
 * 力扣62，不同路径
 * 
 */

class Solution {
    /**
    状态表示：dp[i][j] 表示从start到i，j位置的路径数量
    转移方程：dp[i][j] = dp[i-1][j] + dp[i][j-1];
    初始化：错位dp，默认为0，dp[0][1] = 1;
    填表顺序：左上到右下
    返回值：dp[m][n];
     */
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m+1][n+1];
        dp[0][1] = 1;
        for(int i =1 ;i<= m;i++){
            for(int j = 1;j<=n;j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m][n];
    }
}