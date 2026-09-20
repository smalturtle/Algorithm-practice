/**
 * 力扣139题 单词拆分
 * 
 * 题目链接：https://leetcode.cn/problems/word-break/
 * 给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 * 
 * 说明：
 * 
 * 拆分时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 * 
 * 示例 1：
 */



class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
       //使用set优化
       Set<String> set = new HashSet<String>(wordDict);
       int n = s.length();
       //dp[i]表示前i个字符能否被拆成wordDict里的内容
       boolean[] dp = new boolean[n+1]; 
       dp[0] = true;
        for(int i=1 ;i <= n;i++){
            for(int j = 0;j<i;j++){
                if(dp[j] && set.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];

    }
}