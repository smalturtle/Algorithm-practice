/**
 * 
 * 力扣：84. 柱状图中最大的矩形
 * 
 * 暴力解法：
 * 
 */


class Solution {
    //暴力解法：
    public int largestRectangleArea(int[] heights) {
        //思路：枚举所有的长/高
        int ans = 0;
        int n = heights.length;
        for(int i= 0;i< n;i++){
            int hei = heights[i];
            for(int j = i; j< n;j++){
                //从i下标到j下标作为长
                int len = j -i +1;
                //同时计算此时的最大小：
                hei = Math.min(hei,heights[j]);
                ans = Math.max(ans,len * hei);
            }
        }
        return ans;
    }
}