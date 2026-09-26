/**
 *力扣5.最长回文子串
 * 动态规划
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */

class Solution {
    /**
        dp[i][j] 表示i位置到j位置是否为回文串
     */
    public String longestPalindrome(String ss) {
        char[] s = ss.toCharArray();
        
        int n = s.length;
        boolean[][] dp = new boolean[n][n];

        int maxlen = 1;
        int start = 0,end = 0;
        for(int i = n-1;i>=0;i--){
            for(int j = i;j<n;j++){
                if( s[i] == s[j]){
                    if(j - i <=2){
                        dp[i][j] = true;
                    }else{
                        dp[i][j] = dp[i+1][j-1];
                    }
                }
                if(dp[i][j] && j -i +1 >maxlen){
                    maxlen = j-i+1;
                    start = i;
                    end = j;
                }
            }
        }
        return ss.substring(start,end+1);
    }
}