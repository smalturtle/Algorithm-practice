/**
 * 
 * 力扣84，柱状图中最大的矩形
 * 
 */

class Solution {
    public int largestRectangleArea(int[] oldheights) {
        //单调栈解法：
        int ans = 0;
        int n = oldheights.length;
        // 1. 头尾各补一个 0（哨兵）
        int[] heights = new int[n + 2];
        for (int i = 0; i < n; i++) {
            heights[i + 1] = oldheights[i];
        }
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i< n+2;i++){
            int t = heights[i];
            while(!stack.isEmpty() && t < heights[stack.peek()]){
                int j = stack.pop();
                int left = stack.peek();
                ans = Math.max(ans,(i - left -1) * heights[j]);

            }
            stack.push(i);
        }
        return ans;
    }
}