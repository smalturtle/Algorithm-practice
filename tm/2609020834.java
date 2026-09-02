/**
 * 
 * 力扣78，子集
 */

class Solution {
    List<List<Integer>> ret = new ArrayList<>();
    ArrayList<Integer> path = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        ret.add(new ArrayList<>());
        work(nums,0);
        return ret;
    }
    public void work(int[] nums,int pos){
        if(pos >= nums.length){
            return ;
        }
        for(int i = pos;i<nums.length;i++){
            path.add(nums[i]);
            ret.add(new ArrayList<>(path));
            work(nums,i+1);
            path.remove(path.size() -1);
        }
    }
}