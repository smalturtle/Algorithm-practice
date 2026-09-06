/**
 * 
 * 力扣34. 在排序数组中查找元素的第一个和最后一个位置
 * 
 * 
 */


class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ret = {-1,-1};
        if(nums.length == 0)return ret;
        int l = 0,r = nums.length-1;
        //左偏找到最左侧的位置
        while(l < r){
            int mid = l + (r -l )/2;
            if(nums[mid] < target){
                l = mid+1;
            }else r = mid;
        }
        if(nums[l] != target)return ret;
        ret[0] = l;
        //右偏找到最右侧的位置
        l = 0;r = nums.length -1;
        while(l < r){
            int mid = l + (r -l+1)/2;
            if(nums[mid] > target){
                r = mid -1;
            }else l = mid;
        }
        ret[1] = l;
        return ret;
    }
}