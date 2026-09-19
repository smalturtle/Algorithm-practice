/**
 * 
 * 力扣322题，零钱兑换
 * 
 * 动态规划
 * 
 * 状态表示：dp[i] 表示凑成金额 i 所需的最少硬币数
 * 转移方程：dp[i] = dp[i - coin] + 1 ，枚举coin，表示i位置选择了那一个硬币
 * 初始化：dp[0] = 0
 * 填表顺序：从左往右
 * 返回值：dp[amount]；
 * 
 */


class Solution {
    public int coinChange(int[] coins, int amount) {
        // dp[i] 表示凑成金额 i 所需的最少硬币数
        int[] dp = new int[amount + 1];
        
        // 1. 初始化：求最小值，先填一个比可能的最大答案还大的数字（如 amount + 1）
        Arrays.fill(dp, amount + 1);
        dp[0] = 0; // 凑 0 块钱需要 0 枚

        // 2. 依次计算凑出 1 块钱、2 块钱 ... 直到 amount 块钱
        for (int i = 1; i <= amount; i++) {
            // 3. 尝试所有硬币作为“最后一步”
            for (int coin : coins) {
                if (i >= coin) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        // 4. 返回值：如果 dp[amount] 还是初始值，说明凑不出来，返回 -1
        return dp[amount] > amount ? -1 : dp[amount];
    }
}