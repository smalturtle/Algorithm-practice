/**
 * 
 * 力扣20，有效的括号
 */

class Solution {
    public boolean isValid(String s) {
        Map<Character,Character> hash = new HashMap<>();
        hash.put('(',')');
        hash.put('[',']');
        hash.put('{','}');
        Stack<Character> stack = new Stack<>();
        for(int i =0;i<s.length();i++){
            char c = s.charAt(i);
            if(c == '(' || c == '{' || c == '['){
                stack.push(c);
            }else{
                if(stack.isEmpty())return false;
                char left = stack.peek();
                if(hash.get(left) == c){
                    stack.pop();
                }else return false;
            }
        }
        return stack.isEmpty();
    }
}