/**
 * 力扣：394. 字符串解码
 * 
 * 单栈做法
 * 
 */
class Solution {
    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();

        for(int i =0;i<s.length();i++){
            char c = s.charAt(i);
            if(c != ']')stack.push(c);
            else{
                StringBuilder tmp = new StringBuilder();
                while(!stack.isEmpty() && stack.peek() != '['){
                    tmp.append(stack.pop());
                }
                //纠正顺序：
                tmp.reverse();
                //弹出】
                stack.pop();
                // 3. 完整解析多位数字 k
                StringBuilder numSb = new StringBuilder();
                while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    numSb.append(stack.pop());
                }
                int k = Integer.parseInt(numSb.reverse().toString());

                // 4. 重复 k 次并重新压回栈中（解决嵌套与先后顺序）
                String repeated = tmp.toString().repeat(k);
                for (char ch : repeated.toCharArray()) {
                    stack.push(ch);
                }
            }
        }
        StringBuilder ans = new StringBuilder();
        while (!stack.isEmpty()) {
            ans.append(stack.pop());
        }
        return ans.reverse().toString();
    }
}



