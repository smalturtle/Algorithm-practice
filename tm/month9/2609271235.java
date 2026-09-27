/**
 * 
 * 力扣72.编辑距离
 * 
 * 
 */


class Solution {
    /**
    状态表示：dp[i][j] 表示，将前s1的前i个元素转换成s2的前j个元素所需要的最少步奏

    dp[i][j]=
    替换：dp[i-1][j-1] +1
    删除：dp[i-1][j] +1
    插入：dp[i][j-1] +1
    
    初始化：dp[i][0] = i ,dp[j][0] = j

    填表顺序：左->右  上->下

    返回值：dp[m][n]
     */
    public int minDistance(String word1, String word2) {
        char[] s1 = word1.toCharArray();
        char[] s2 = word2.toCharArray();

        int m = s1.length;
        int n = s2.length;
        int[][] dp = new int[m+1][n+1];
        for(int i=0;i<=m;i++)dp[i][0] = i;
        for(int j=0;j<=n;j++)dp[0][j] = j;

        for(int i = 1;i<=m;i++){
            for(int j =1;j<=n;j++){
                if(s1[i-1] == s2[j-1]){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j] = 1+Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]));
                }
            }
        }
        return dp[m][n];
    }
}