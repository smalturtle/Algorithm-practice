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
 * 力扣：105前序遍历和中序遍历构造二叉树
 */

//方法1:全局 preIndex + 哈希表
class Solution {
    int preindex = 0;
    Map<Integer,Integer> hash = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //前置处理：中序遍历 节点 -> 下标映射
        for(int i=0;i<inorder.length;i++){
            hash.put(inorder[i],i);
        }
        return build(preorder,0,inorder.length-1);
    }
    public TreeNode build(int[] preorder,int left ,int right){
        if(left > right) return null;

        //拿到前序遍历的节点，也即为根节点
        int tmp = preorder[preindex++];
        TreeNode root = new TreeNode(tmp);
        //找到其在中序遍历的位置
        int mid = hash.get(tmp);
        //递归构造左右子树
        root.left = build(preorder,left,mid -1);
        root.right = build(preorder,mid+1,right);
        return root;
    }
}

//方法二：省去hash表

//方法二：无需区间，，根据中序遍历性质先左后右，优化了hash表，修改了递归出口
class Solution {
    int preindex = 0;
    int inindex = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder,inorder,Integer.MAX_VALUE);
    }
    public TreeNode build(int[] preorder,int[] inorder,int stop){
        if(preindex >= preorder.length) return null;

        if(inorder[inindex] == stop) {
            inindex++;
            return null;
        }
        TreeNode root = new TreeNode(preorder[preindex++]);
        root.left = build(preorder,inorder,root.val);
        root.right = build(preorder,inorder,stop);
        return root;
    }
}