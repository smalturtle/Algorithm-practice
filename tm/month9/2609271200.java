/**'
 * 
 * 
 * 力扣1143.最长公共子序列
 * 
 * ' */



class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        char[] s1 = text1.toCharArray();
        char[] s2 = text2.toCharArray();
        int m = s1.length;
        int n = s2.length;
        int[][] dp = new int[m+1][n+1];

        for(int i=1;i<=m;i++){
            for(int j =1;j<=n;j++){
                if(s1[i-1] == s2[j-1]){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j-1],Math.max(dp[i-1][j],dp[i][j-1]));
                }
            }
        }
        return dp[m][n];
    }
}