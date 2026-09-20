/**
 * 
 * 
 * 力扣300题 最长严格递增子序列
 * 
 * 题目链接：https://leetcode.cn/problems/longest-increasing-subsequence/
 * 
 * 题目描述：
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 * 
 * 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 * 
 */


class Solution {
    public int lengthOfLIS(int[] nums) {
        //dp[i] 表示以i结尾的最长严格递增子序列的长度
        //转移方程：挨个遍历从0到i的位置
        //初始化：
        int n = nums.length;
        int[] dp = new int[n];
        int ans = 0;
        for(int i =0;i<n;i++){
            for(int j =0;j<i;j++){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[j]+1,dp[i]);
                }
            }
            ans = Math.max(ans,dp[i]);
        }
        return ans+1;
    }
}