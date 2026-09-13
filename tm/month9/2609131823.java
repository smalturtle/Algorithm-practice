/**
 * 
 * 
 * 力扣215题：数组中的第K个最大元素
 * 
 * 题目描述：
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 * 
 * 示例：
 * 输入：nums = [3,2,1,5,6,4], k = 2
 * 输出：5
 * 
 * 输入：nums = [3,2,3,1,2,4,5,5,6], k = 4
 * 输出：4
 * 
 * 选择法，o（n）时间复杂度，o（1）空间复杂度
 */


class Solution {
    //快速选择算法：
    public int findKthLargest(int[] nums, int k) {
        int target = nums.length - k;
        int ans = quickSelect(nums,0,nums.length -1,target);
        return ans;
    }
    public int quickSelect(int[] nums,int left,int right,int target){
        if(left >= right){
            return nums[left];
        }
        //取中间值为基准
        int proiv = nums[(left + right)/2];
        int i = left,j = right;
        while(i <= j){
            while(nums[i] < proiv)i++;
            while(nums[j] > proiv)j--;
            // 交换后必须手动推进指针，否则遇重复值会卡死在原地
            if(i<=j){
                swap(i,j,nums);
                i++;
                j--;
            }
        }
        //交换完之后看target下标在哪里，继续往哪里走
        if(target >= i){
            return quickSelect(nums,i,right,target);
        }else{
            return quickSelect(nums,left,i-1,target);
        }
    }
    public void swap(int i,int j,int[] nums){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}