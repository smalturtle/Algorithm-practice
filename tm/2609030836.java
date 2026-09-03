/**
 * 
 * 力扣17，电话号码的字母组合
 */

class Solution {
    List<String> ret = new ArrayList<>();
    StringBuilder path = new StringBuilder();
    Map<Character,String> hash = new HashMap<>();
    public List<String> letterCombinations(String digits) {
        //处理一个映射数组：
        hash.put('2',"abc");
        hash.put('3',"def");
        hash.put('4',"ghi");
        hash.put('5',"jkl");
        hash.put('6',"mno");
        hash.put('7',"pqrs");
        hash.put('8',"tuv");
        hash.put('9',"wxyz");
        //执行递归
        dfs(digits,0);
        return ret;
    }
    public void dfs(String s,int pos){
        if(pos == s.length()){
            ret.add(path.toString());
            return;
        }

        char c = s.charAt(pos);
        for(int i =0;i<hash.get(c).length();i++){
            path.append(hash.get(c).charAt(i));
            dfs(s,pos+1);
            path.deleteCharAt(path.length() -1);
        }
    }

}