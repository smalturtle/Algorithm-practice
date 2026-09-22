/**
 * 
 * 
 * 力扣：152. 乘积最大子数组    
 */


class Solution {
    public int maxProduct(int[] nums) {
        //状态表示：f[i] 表示i以结尾的乘积最大
        //         g[i] 表示以i结尾成绩最小
        int n= nums.length;

        int[] f = new int[n];
        int[] g = new int[n];
        f[0] = g[0] = nums[0];
        int ans = nums[0];
        for(int i =1 ;i<n;i++){
            if(nums[i] > 0){
                f[i] = Math.max(nums[i],nums[i] * f[i-1]);
                g[i] = Math.min(nums[i] * g[i-1],nums[i]);
            }else if(nums[i] == 0){
                f[i] = g[i] = 0;
            }else{
                f[i] = Math.max(nums[i], nums[i] * g[i-1]);
                g[i] = Math.min(nums[i],f[i-1] * nums[i]);
            }
            ans = Math.max(ans,f[i]);
        }
        return ans;
    }
}