/**
 * 力扣55，跳跃游戏
 * 中等
 * 贪心
 */


class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int scope = 0;
        for(int i = 0;i< n; i++){
            // 当前位置超过了能跳到的最远范围，说明卡住了
            if(i > scope) return false;
            scope = Math.max(scope,i + nums[i]);
            if(scope >= n -1)return true;
        }
        return false;
    }
}