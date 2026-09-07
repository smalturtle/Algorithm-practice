/**
 * 
 * 力扣：33搜索旋转排序数组
 * 
 * 方法1:找到分裂点，然后分别在左右两边进行二分查找，复杂度n+log(n)
 * 
 * 方法二：一次二分查找，复杂度log(n)   
 * 1.如果中间的值大于最右边的值，则左半部分是有序的，右半部分是无序的，如果目标值在左半部分，则继续在左半部分查找，否则在右半部分查找
 * 2.如果中间的值小于最右边的值，则右半部分是有序的，左半部分是无序的，如果目标值在右半部分，则继续在右半部分查找，否则在左半部分查找
 
 * 
 * 
 */

class Solution {
    public int search(int[] nums, int target) {
        //找出k的位置
        int k = nums.length;
        for(int i =1;i<nums.length;i++){
            if(nums[i] <= nums[i -1]){
                k = i;
                break;
            }
        }

        int ret = work(nums,0,k -1,target);
        if(ret != -1){
            return ret;
        }
        ret = work(nums,k, nums.length -1,target);
        return ret;
    }
    public int work(int[]nums,int left,int right,int target){
        while(left < right){
            int mid = left + (right - left)/2;
            if(nums[mid] < target){
                left = mid+1;
            }else right = mid;
        }
        if(left < nums.length && nums[left] == target){
            return left;
        }
        return -1;
    }
}

/**
 * 
 * 
 * 方法二：代码：
 * 
 */

class Solution {
    public int search(int[] nums, int target) {
        int left = 0,right = nums.length -1;
        while(left < right){
            int mid = left +(right -left)/2;
            //如果左边有序：
            if(nums[left] <= nums[mid]){
                if(target >= nums[left] && target <= nums[mid]){
                    right = mid;
                }else left = mid +1;
            }
            //如果右侧有序：
            else{
                if(target > nums[mid] && target <= nums[right]){
                    left = mid+1;
                }else right = mid;
            }
        }
        return nums[left] == target ? left : -1;     
    }
   
}