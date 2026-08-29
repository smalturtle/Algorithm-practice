/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
/**
 * 
 * 
 * 
 * 力扣：108.将有序数组转换为平衡二叉搜索树
 * 思路：递归创建，每次在区间里选取根节点，然后递归创建左子树和右子树
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return work(nums,0,nums.length-1);
    }
    public TreeNode work(int[] nums,int left ,int right){
        if(left > right)return null;

        int mid = (left+right)/2;
        TreeNode root = new TreeNode(nums[mid]);

        root.left = work(nums,left,mid-1);
        root.right = work(nums,mid+1,right);
        return root;
    }
}