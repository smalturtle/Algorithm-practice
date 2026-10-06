/*
 * @Author: your name
 * @Date: 2026-10-06 17:57:57
 * @LastEditTime: 2026-10-06 17:58:00
 * @LastEditors: your name
 * @Description: 
 * @FilePath: \tm\month10\061757.java
 * 
 * 力扣32题：最长有效括号
 */


class Solution {
    public int longestValidParentheses(String s) {
        int maxLen = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        
        // 0 的前面是 -1，作为初始的虚拟断点
        stack.push(-1);

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                // 左括号先存着，等后面的右括号来消
                stack.push(i);
            } else {
                // 遇到右括号，先弹出一个
                stack.pop();
                
                if (stack.isEmpty()) {
                    // 弹空了说明当前的 ')' 没配上对，它成了新的断点
                    stack.push(i);
                } else {
                    // 没弹空说明配对成功，当前位置减去此时的栈顶（断点）就是长度
                    maxLen = Math.max(maxLen, i - stack.peek());
                }
            }
        }

        return maxLen;
    }
}