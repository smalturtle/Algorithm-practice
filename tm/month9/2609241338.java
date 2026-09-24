/**
 * 
 * 力扣416，分割等和子集
 * 
 * 动态规划
 * 
 */


class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum =0;
        for(int x : nums){
            sum+=x;
        }
        //如果是奇数，那肯定不可能
        if(sum % 2 ==1){
            return false;
        }
        int target = sum/2;
        /**
        状态表示：dp[i][j] 表示从前i个数字里面挑数字，能否凑成和为j的
        转移方程：dp[i][j] = dp[i-1][j - nums[i]]；
        初始化，第一列为true
        填表顺序：左侧到右侧
        返回值：dp[n][target]
         */
        boolean[][] dp = new boolean[n+1][target +1];
        for(int i =0;i<=n;i++){
            dp[i][0] = true;
        }
        for(int i =1;i<= n;i++){
            //注意下标映射
            for(int j = 1;j<=target;j++){
                dp[i][j] = dp[i-1][j];
                if(j - nums[i-1] >=0){
                    dp[i][j] = dp[i-1][j - nums[i-1]] || dp[i-1][j];
                }
            }
        }
        return dp[n][target];
    }
}