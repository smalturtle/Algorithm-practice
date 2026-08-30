/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

 //递归函数的职责：
 //“在以 root 为根节点的树中，寻找 p 或 q（或它们的最近公共祖先）并返回对应节点；如果都没找到，返回 null。”
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;

        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right =lowestCommonAncestor(root.right,p,q);

        if(left != null && right != null) return root;

        return left != null ? left :right;
    }
}