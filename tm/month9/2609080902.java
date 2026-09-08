/**
 * 
 * 力扣4. 寻找两个正序数组的中位数
 *      
 */

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //如果是奇数：
        int n = nums1.length + nums2.length;
        if(n %2 == 1){
            return work(nums1,0,nums2,0,(n+1)/2);
        }else{
            return (work(nums1,0,nums2,0,n/2) + work(nums1,0,nums2,0,n/2+1))/2.0;
        }
    }
    //nums1或nums2里挑数字，找到第k小的数字，每次排出k/2个
    public int work(int[] nums1,int i,int[] nums2,int j,int k){
        //如果其中一个为空：
        if(i >= nums1.length){
            return nums2[j+k-1];
        }
        if(j >= nums2.length){
            return nums1[i+k-1];
        }
         if(k == 1){
            return Math.min(nums1[i],nums2[j]);
        }

        //在num1里找到第k/2元素
        int val1 = i+k/2-1 < nums1.length ? nums1[i+k/2-1] : Integer.MAX_VALUE;
        //在num2里找到第k/2元素
        int val2 = j+k/2-1 < nums2.length ? nums2[j+k/2-1] : Integer.MAX_VALUE;
        //如果其中一段的前半段比较小，那就给较小的半段排除掉
        if(val1 < val2){
            return work(nums1,i+k/2,nums2,j,k-k/2);
        }else{
            return work(nums1,i,nums2,j+k/2,k-k/2);
        }
    }
}