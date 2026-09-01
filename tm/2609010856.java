/**
 * 力扣207，课程表
 * 图的拓扑排序，判断是否存在环 
 * 如果存在环，则返回false，否则返回true        
 * 思路：
 * 1. 构建入度出度的图
 * 2. 统计入度为0的节点，将所有入度为0的节点加入到队列中
 * 3. 遍历队列，将队列中的节点出队，并将其指向的节点的入度减1
 * 4. 如果某个节点的入度减1后为0，则将该节点加入到队列中
 * 5. 如果队列为空，则返回true，否则返回false
 */
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //入度出度的图
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i =0;i< numCourses;i++){
            graph.add(new ArrayList<>());
        }
        //统计入度为0的节点

        int[] indegree = new int[numCourses];
        for(int i=0;i< prerequisites.length;i++){
            int pre = prerequisites[i][1],cur = prerequisites[i][0];
            graph.get(pre).add(cur);
            indegree[cur]++;
        }

        //将所有入度为0的节点加入到队列中
        Queue<Integer> q = new LinkedList<>();
        for(int i=0 ;i<numCourses;i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }
        int cnt =0;
        //遍历：
        while(!q.isEmpty()){
            int tmp = q.poll();
            cnt++;
            for(int i=0;i<graph.get(tmp).size();i++){
                int next = graph.get(tmp).get(i);
                indegree[next]--;
                if(indegree[next] == 0){
                    q.offer(next);
                }
            }
        }
        return cnt == numCourses;
    }
}