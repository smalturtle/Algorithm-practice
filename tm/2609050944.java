/**
 * 
 * 
 * 79.单词搜索
 * 
 *思路：回溯法，从board的每个位置开始，如果board[i][j] == word[0]，则以board[i][j]为起点，进行深度优先搜索
 * 
 */

class Solution {

    int[] dx = new int[]{1,-1,0,0};
    int[] dy = new int[]{0,0,1,-1};
    boolean[][] visit;
    int m,n;
    //标志位，剪枝
    boolean flag;
    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        visit = new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j =0;j<n;j++){
                if(board[i][j] == word.charAt(0)){
                    visit[i][j] = true;
                    work(board,word,1,i,j);
                    visit[i][j] = false;
                }
                if(flag) return true;
            }
        }
        return false;
    }

    public void work(char[][] board,String word,int pos,int i,int j){

        if(pos == word.length()){
            flag = true;
            return ;
        }

        if(flag == true){
            return ;
        }
        
        for(int k =0;k <4;k++){
            int x = dx[k] + i;
            int y = dy[k] + j;
            if(x<0||y<0||x>=m||y>=n||word.charAt(pos) != board[x][y] || visit[x][y] == true){
                continue;
            }
            visit[x][y] = true;
            work(board,word,pos+1,x,y);
            visit[x][y] = false;
        }
    }
}