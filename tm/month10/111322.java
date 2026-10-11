/**
 * 力扣139.单词拆分
 * 
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