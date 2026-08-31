/**
 * 
 * 力扣994，腐烂的橘子
 * 
 * 思路清晰，就是在广搜的时候维护一些值，并且统计新鲜橘子的数量，如果新鲜橘子数量为0，则返回0，否则返回-1
 */
class Node{
    int x;
    int y;
    public Node(int x,int y){
        this.x = x;
        this.y = y;
    }
}
class Solution {
    
    int[] dx = new int[]{1,-1,0,0};
    int[] dy = new int[]{0,0,1,-1};
    //记录层级
    int tim = -1;
    public int orangesRotting(int[][] grid) {
        Queue<Node> q = new LinkedList<>();
        //先将所有腐烂的橘子纳入队列

        int m = grid.length;
        int n = grid[0].length;
        //同时统计新鲜橘子的数量
        int fresh = 0;
        for(int i=0;i<m;i++){
            for(int j =0;j<n;j++){
                if(grid[i][j] == 2){
                    q.offer(new Node(i,j));
                }
                if(grid[i][j] == 1)fresh++;
            }
        }
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                Node tmp = q.poll();
                
                //遍历上下左右四个人节点
                for(int k =0;k<4;k++){
                    int x = tmp.x +dx[k];
                    int y = tmp.y +dy[k];
                    if(x <0 || y<0 || x >=m || y>= n||grid[x][y] ==0 || grid[x][y] != 1)continue;
                    //找到一个新鲜橘子就减少一个并且修改成腐烂
                    fresh--;
                    grid[x][y] = 2;
                    q.offer(new Node(x,y));
                }
            }
            tim++;
        }
        if(fresh >0)return -1;
        return Math.max(0,tim);
    }
}