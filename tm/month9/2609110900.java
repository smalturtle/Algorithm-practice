/**
 * 力扣739题：每日温度
 * 
 * 给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，其中 answer[i] 是指在第 i 天之后，才会有更高的温度。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 * 
 * 示例 1:
 * 输入: temperatures = [73,74,75,71,69,72,76,73]
 * 输出: [1,1,4,2,1,1,0,0]
 * 
 * 示例 2:
 * 输入: temperatures = [30,40,50,60]
 * 输出: [1,1,1,0]
 * 
 * 
 * 
 * 
 * 单调栈思路复习：
 * 
 * 
 * 单调栈的核心思想是用栈维护一个单调递增或单调递减的序列，专门用来在 $O(n)$ 时间内解决“寻找数组中下一个/上一个更大或更小元素”的问题。
 * 对于当前题目 739. 每日温度：目标是找到每个元素右侧第一个比它大的元素。核心机制栈内存放什么：存下标索引 $i$（因为题目要求计算天数差 
 * i - prevIndex，存下标不仅能算跨度，也能随时查到对应的温度值）。栈内单调性：保持从栈底到栈顶单调递减（即越靠近栈顶，温度越低）。
 * 触发结算的时机：遍历遇到一个比栈顶温度高的新元素时，栈顶元素就找到了它“右侧第一个更高的温度”，立即出栈并结算答案。
 */


class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        //维护一个底部到顶部递减的单调栈
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<n;i++){
            int tmp = temperatures[i];
            while(!stack.isEmpty() && tmp > temperatures[stack.peek()]){
                int k = stack.pop();
                ans[k] = i - k; 
            }
            stack.push(i);
        }
        return ans;
    }
}