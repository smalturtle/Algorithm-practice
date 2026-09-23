/**
 * 力扣287题：寻找重复数
 * 
 * 
 */


class Solution {
    public int findDuplicate(int[] nums) {
        // 第一阶段：快慢指针找相遇点
        int slow = nums[0];
        int fast = nums[nums[0]];
        
        while (slow != fast) {
            slow = nums[slow];           // 走 1 步
            fast = nums[nums[fast]];     // 走 2 步
        }
        
        // 第二阶段：寻找环入口（重复元素）
        // 一个指针从起点 0 出发，另一个从相遇点出发，每次各走 1 步
        int ptr1 = 0;
        int ptr2 = slow;
        
        while (ptr1 != ptr2) {
            ptr1 = nums[ptr1];
            ptr2 = nums[ptr2];
        }
        
        return ptr1;
    }
}