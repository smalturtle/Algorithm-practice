/**
 * 力扣70题，爬楼梯，动态规划
 * 
 */


class Solution {
    //动态规划，从起始位置爬楼梯，爬到以i结尾的位置有多少种爬法
    //转移方程：f[i] = f[i-1] + f[i-2];
    //初始化：f[0] = 1 f[1] = 2
    //填表顺序：从左往右
    //返回值f[n-1]
    public int climbStairs(int n) {
        if(n ==1) return 1;
        int[] f = new int[n];
        f[0] = 1;
        f[1] = 2;
        for(int i=2;i<n;i++){
            f[i] = f[i-1] + f[i-2];
        }
        return f[n-1];
    }
}