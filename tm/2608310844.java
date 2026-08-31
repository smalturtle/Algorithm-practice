/**
 * 200.岛屿数量，dfs深搜
 */

class Solution {
    int[] dx = new int[]{1,-1,0,0};
    int[] dy = new int[]{0,0,1,-1};

    int m =0,n =0;
    public int numIslands(char[][] grid) {
        int ans = 0;
        
        m = grid.length;
        n = grid[0].length;
        for(int i=0;i<m ;i++){
            for(int j =0;j<n;j++){
                if(grid[i][j] == '1'){
                    ans++;
                    dfs(grid,i,j);
                }
            }
        }
        return ans;
    }
    public void dfs(char[][] grid,int x,int y){

        grid[x][y] = '0';
        for(int i =0;i<4;i++){
            int xx = x + dx[i];
            int yy = y + dy[i];
            if(xx <0 || yy<0|| xx>=m || yy >=n||grid[xx][yy] == '0')continue;
            dfs(grid,xx,yy);
        }
    }
}