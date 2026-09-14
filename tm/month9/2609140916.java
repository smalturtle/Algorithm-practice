/**
 * 力扣第347题：前 K 个高频元素 桶排序  
 * 
 * 方法二：
 * 
 */


class Solution {
    //方法二：通排序 o（n）复杂度
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        //先统计所有的次数：
        Map<Integer,Integer> map = new HashMap<>();
       for(int i=0;i<n;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
       }
       List<Integer>[] arr = new ArrayList[n+1];
        //加入桶中：
        for(Map.Entry<Integer,Integer> x: map.entrySet()){
            int val = x.getKey();
            int cnt = x.getValue();
            if(arr[cnt] == null){
                arr[cnt] = new ArrayList();
            }
            arr[cnt].add(val);
        }
        int[] ans = new int[k];
        int j =0;
        //此时就是依据次数的升序，从后向前遍历，统计
        for(int i = n;i>=0;i--){
            if(arr[i] == null)continue;
            for(int x: arr[i]){
                k--;
                ans[j++] = x;
                if(k == 0)return ans;
            }
        }
        return ans;
    }
}