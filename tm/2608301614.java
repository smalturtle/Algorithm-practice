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

//递归函数的职责：返回经过该节点的左右子路径其中的一个最大和
class Solution {
    int ret = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        work(root);
        return ret;
    }
    public int work(TreeNode root){
        if(root == null) return 0;

        int left = work(root.left);
        int right= work(root.right);

        ret = Math.max(ret,left+right+root.val);
        //之所以将0加入进来是因为：左右路径并不一定非要选择一个，也可以都不选择
        return Math.max(left+root.val,Math.max(right+root.val,0));
    }
}