/**
 * 
 * 
 * 力扣31.下一个排列    
 * 
 */


class Solution {
    public void nextPermutation(int[] nums) {
        
        //先找到第一个非升序的数字
        int n = nums.length;
        int i = n-2;
        while(i>=0 && nums[i] >= nums[i+1])i--;
        if(i == -1){
            reverse(i+1,n-1,nums);
            return ;
        }
        //使用i位置和第一个大于他的数字位置交换：
        int j = n-1;
        while(j>=0 && nums[j] <= nums[i])j--;
        swap(i,j,nums);

        //奖剩下的i以后的数字全部翻转：
        reverse(i+1,n-1,nums);
    }

    public void reverse(int p,int q, int[]nums){
        while(p <q){
            swap(p,q,nums);
            p++;
            q--;
        }
    }
    public void swap(int i,int j,int[] nums){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}