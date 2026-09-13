/**
 * 力扣215. 数组中的第K个最大元素
 * 小根队解法
 * 
 * 
 * 
 */

class Solution {
    public int findKthLargest(int[] nums, int k) {
        //维护一个小根队
        PriorityQueue<Integer> heap = new PriorityQueue<>((a,b) ->a -b );
        for(int x : nums){
            heap.offer(x);
            while(heap.size() > k){
                heap.poll();
            }
        }
        return heap.peek();
    }
}