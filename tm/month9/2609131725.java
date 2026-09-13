/**
 * 
 * 力扣215. 数组中的第K个最大元素
 * 
 * 大根队解法
 */


class Solution {
    public int findKthLargest(int[] nums, int k) {
        //维护一个大根队
        PriorityQueue<Integer> heap = new PriorityQueue<>((a,b) -> b -a );
        for(int i =0;i<nums.length;i++){
            heap.add(nums[i]);
        }
        int ans = 0;
        for(int i=0;i<k;i++){
            ans = heap.poll();
        }
        return ans;
    }
}