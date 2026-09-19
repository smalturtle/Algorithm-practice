/**
 * 
 * 力扣279题，完全平方数
 * 
 * 动态规划
 * 
 * 状态表示：dp[i][j] 表示选到i结尾的位置的时候，凑成和为j的时候，所需最少步奏
 * 转移方程：dp[i][j] = 选i，dp[i-1][j - a[i]] +1 不选i：dp[i-1][j]
 * 初始化：第一行全是0，第一列0
 * 填表顺序 上->下，左 -> 右
 * 返回值：dp[1-> n-1][n]
 * 
 * 这是我第一次的想法，之比较麻烦的，其实一维解法就够用了
 */

class Solution {
    public int numSquares(int n) {
        //先将完全平方数组给建造出来
        int m = (int)(Math.pow(n,0.5));
        int[] a = new int[m+1];
        for(int i=0;i*i<=n;i++){
            a[i] = i*i;
        }
        //状态表示：dp[i][j] 表示选到i结尾的位置的时候，凑成和为j的时候，所需最少步奏
        //转移方程：dp[i][j] = 选i，dp[i-1][j - a[i]] +1 不选i：dp[i-1][j]
        //初始化：第一行全是0，第一列0
        //填表顺序 上->下，左 -> 右
        //返回值：dp[1-> n-1][n]
        int ans = n;
        int[][] dp = new int[m+1][n+1];

        for(int j =0;j<=n;j++){
            dp[0][j]= n+1;
        }
        for(int i=1;i<= m;i++){
            for(int j =1;j<=n;j++){
                dp[i][j] = dp[i-1][j];
                if(j - a[i] >=0){
                    dp[i][j] = Math.min(dp[i][j],dp[i][j-a[i]]+1);
                }
            }
        }
        return dp[m][n];
    }
}