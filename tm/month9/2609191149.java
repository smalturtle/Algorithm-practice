/**
 * 
 * 力扣279题，完全平方数
 * 
 * 动态规划
 * 
 * 
 */


class Solution {
    public int numSquares(int n) {
        //一维解法：
        //状态表示：凑成n和，dp【i】表示选到i位置的时候用到的最少数字的数量
        //转移方程：dp[i] = dp[i - j*j] +1 ，枚举j，表示i位置选择了那一个数字
        //初始化
        //填表顺序
        //返回值：dp[n]；
        int[] dp = new int[n+1];
        Arrays.fill(dp,n);
        dp[0] = 0;
        for(int i =1;i<=n;i++){
            //每个平方数枚举
            for(int j = 1;j*j<=n;j++){
                if(i - j*j >=0){
                    dp[i] = Math.min(dp[i],dp[i - j*j]+1);
                }
            }
        }
        return dp[n];
    }
}