/**
 * 
 * 力扣560
 * 力扣题目：https://leetcode.cn/problems/subarray-sum-equals-k/
 * 解题思路：
 * 1. 使用前缀和数组
 * 2. 使用哈希表
 * 3. 使用双指针
 * 4. 使用滑动窗口
 * 5. 使用二分查找
 * 6. 使用动态规划
 * 7. 使用贪心算法
 * 8. 使用分治算法
 */


class Solution {
  public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> hash = new HashMap<>();
        int sum =0;
        int cnt =0;
        hash.put(0,1);
        for(int x: nums){
            sum+=x;
            cnt+=hash.getOrDefault(sum - k,0);
            hash.put(sum,hash.getOrDefault(sum,0)+1);
        }
        return cnt;
        
    }











    // public int subarraySum(int[] nums, int k) {
    //     Map<Integer,Integer> map = new HashMap<Integer,Integer>();
    //     map.put(0,1);
    //     int ret =0,sum =0;
    //     for(int x:nums){
    //         sum+=x;
    //         ret+=map.getOrDefault(sum - k,0);
    //         map.put(sum,map.getOrDefault(sum,0)+1);
    //     }
    //     return ret;
    // }
}