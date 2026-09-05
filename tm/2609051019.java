/**
 * 
 * 力扣131，分割回文串
 * 
 * 
 * 
 * 先写出上述标准回溯版本：代码没有复杂的 dp[][] 索引计算，几分钟就能 bug-free 写完，结构极具可读性。主动提出优化点：
 * 写完后告诉 msg：“在这个解法中，isPalindrome 在递归树的不同分支可能重复校验同一个子串。如果数据规模 $N$ 较大，
 * 可以用 $O(N^2)$ 的二维布尔 DP 预处理所有子串的回文状态，把每次校验降为 $O(1)$。” 这样既展示了扎实的基本功，又体现了性能敏感度。
 * 
 */


class Solution {
    List<List<String>> ret = new ArrayList<>();

    List<String> path = new ArrayList<>();

    public List<List<String>> partition(String s) {
        work(s);
        return ret;
    }
    public void work(String s){

        //切割完毕（字符串被切空了），那就可以加入结果里了
        if(s.equals("")){
            ret.add(new ArrayList<>(path));
            return ;
        }
        //枚举切割的位置，注意必须是 <= s.length()
        for(int i =1;i<=s.length();i++){
            String left = s.substring(0,i);
            String right = s.substring(i,s.length());
            //前半段是回文，才继续切后半段
            if(isPail(left)){
                path.add(left.toString());
                work(right);
                path.remove(path.size() -1);
            }
        }
    }
    public boolean isPail(String s){
        int left = 0,right = s.length()-1;
        while(left <right){
            if(s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}