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

 //暴力枚举解法
class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null) return 0;
        int ret = 0;
        ret+=work(root,targetSum);
        ret+=pathSum(root.left,targetSum);
        ret+=pathSum(root.right,targetSum);
        return ret;
    }
    public int work(TreeNode root,long targetSum){
        if(root == null) return 0;

        int ret = 0;
        if(targetSum == root.val)ret++;

        ret+=work(root.left,targetSum - root.val);
        ret+=work(root.right,targetSum - root.val);

        return ret;
    }
}