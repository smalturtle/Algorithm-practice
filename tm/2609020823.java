/**
 * 
 * 力扣46，全排列   
 * 
 */

class Solution {
    List<List<Integer>> ret = new ArrayList<>();

    List<Integer> path = new ArrayList<>();
    boolean[] sign = new boolean[7];
    public List<List<Integer>> permute(int[] nums) {
        work(nums);
        return ret;
    }
    public void work(int[] nums){
        if(path.size() == nums.length){
            ret.add(new ArrayList<>(path));
            return;
        }

        for(int i =0;i<nums.length;i++){
            if(sign[i] == false){
                sign[i] = true;
                path.add(nums[i]);
                permute(nums);
                path.remove(path.size()-1);
                sign[i] = false;
            }
        }
    }
}