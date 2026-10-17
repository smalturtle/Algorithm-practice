/**
 * 力扣，接雨水
 * 
 */

//存下标
class Solution {
    public int trap(int[] height) {
        //处理右边最大数组(存下标)
        int n = height.length;

        int[] right = new int[n];
        Arrays.fill(right,n-1);
        int max_index = n-1;
        for(int i = n-1;i >=0 ;i--){
            if(height[i] > height[max_index]){
                max_index = i;
            }
            right[i] = max_index;
        }
        //从左往右侧遍历查找
        max_index = 0;
        int ret =0;
        for(int i =0 ;i< n;i++){
            if(height[i] > height[max_index]){
                max_index = i;
            }
            int hei = Math.min(height[max_index],height[right[i]]);
            ret+=hei-height[i];
        }
        return ret;
    }
}

//存最大值
class Solution {
    public int trap(int[] height) {
        int n = height.length;
        if (n == 0) return 0;

        // rightMax[i] 表示下标 i 及其右侧的最大柱子高度
        int[] rightMax = new int[n];
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        int leftMax = 0;
        int ret = 0;
        for (int i = 0; i < n; i++) {
            leftMax = Math.max(leftMax, height[i]);
            // 水量由左右较矮的挡板决定，并减去自身高度
            ret += Math.min(leftMax, rightMax[i]) - height[i];
        }

        return ret;
    }
}

//双指针

class Solution {
    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        int ret = 0;

        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);

            if (leftMax < rightMax) {
                ret += leftMax - height[left];
                left++;
            } else {
                ret += rightMax - height[right];
                right--;
            }
        }

        return ret;
    }
}