/**
 * 力扣39，组合总和     
 * 给你一个无重复元素的整数数组candidates和一个目标整数target，找出candidates中可以使数字和为目标数target的 所有不同组合，
 * 并以列表形式返回。你可以按任意顺序返回这些组合。
 * 
 * candidates中的同一个数字可以无限制重复被选取。如果至少一个数字的被选数量不同，则两种组合是不同的。
 * 
 * 对于给定的输入，保证和为target的不同组合数少于150个。
 * 
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