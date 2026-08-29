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
 * 力扣98. 验证二叉搜索树
 * 
 * 思路：中序遍历必然有序，只需维护一个指针就行
 */
class Solution {
    long pre = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;

        //根据性质，执行中序遍历
        boolean left = isValidBST(root.left);
        if(left == false) return false;
        if(root.val <= pre) return false;
        pre = root.val;
        boolean right = isValidBST(root.right);
        return right;
    }
}