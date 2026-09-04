/**
 * 力扣39，组合总和     
 *
 * 递归函数的定义
 * 
 * 当前已选择路径 path 的基础上，只允许使用下标从 start 到末尾的候选数字，找出所有能凑出剩余目标值 remain 的组合，并全部塞入 res
 * 、
 * 递归和回溯的区别
 * 
 * 直观对比：有递归，但不叫回溯

求斐波那契数列或二叉树的前序遍历也是纯递归：

Java
// 纯递归：一路传下去，返回结果或处理当前节点，没有“撤销”这一动作
void preOrder(TreeNode root) {
    if (root == null) return;
    print(root.val);
    preOrder(root.left);
    preOrder(root.right);
}
这里函数不断调用自己，但它只是按顺序访问节点，没有做试探，也不需要抹除痕迹。

回溯的灵魂：必须有“撤销选择”
 * 
 */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        
        // 排序是为了后续可以快速剪枝
        Arrays.sort(candidates);
        
        backtrack(candidates, target, 0, path, res);
        return res;
    }

    private void backtrack(int[] candidates, int remain, int start, List<Integer> path, List<List<Integer>> res) {
        // 终止条件：刚好凑齐
        if (remain == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        // 尝试从 start 开始的每一个候选数
        for (int i = start; i < candidates.length; i++) {
            // 剪枝：如果当前数字已经大于剩余目标，由于数组有序，后续更大，直接结束循环
            if (candidates[i] > remain) {
                break;
            }

            path.add(candidates[i]);               // 1. 做选择
            backtrack(candidates, remain - candidates[i], i, path, res); // 2. 下一层继续选（传 i 允许重复选自己）
            path.remove(path.size() - 1);           // 3. 撤销选择（回溯）
        }
    }
}