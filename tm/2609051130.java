/**
 * 
 * 
 * 力扣51题：N皇后      n皇后问题是经典的回溯问题，需要使用回溯算法来解决。 
 * 
 * 对角线方向,倾斜方向,恒定特征,数组下标映射,下标范围
主对角线,左上 → 右下（\）,row - col 恒定,row - col + n,"[1, 2n−1]"
副对角线,右上 → 左下（/）,row + col 恒定,row + col,"[0, 2n−2]"
 * 


 为什么逐行推进（递归深度）：$n$ 个皇后要在 $n \times n$ 的棋盘上互不攻击，根据鸽巢原理，每一行必须且只能放一个。
 所以递归树的深度固定为 $n$，参数 row 从 $0$ 递增到 $n$；当 row == n 时，说明前 $n$ 行全部合法放满，这就成了天然的递归终止条件。
 
 为什么选择枚举列（树的宽度）：在确定了当前行 row 之后，唯一的自由度就是“这一行的皇后放在第几列”。从 $col = 0$ 到 $n-1$ 枚举列，
 是代码实现上最直观、边界最整齐的写法（每行可选位置都是连续的 $0 \dots n-1$）。
 
 关于“枚举对角线”：你说得完全没错，理论上按斜线切分也能覆盖全图，
 但对角线的长度是不规则的（有的长为 1，有的长为 $n$），不仅递归树参差不齐，边界处理也极度繁琐。而按行推进、按列枚举，不仅符合人类思考棋盘的直觉，
 也是面试中逻辑最不易出错的标准解法。
 * 
 * 
 */

class Solution {
    List<List<String>> ret = new ArrayList<>();
    boolean[] row,col,dig1,dig2;
    char[][] board;
    public List<List<String>> solveNQueens(int n) {
        board = new char[n][n];
        row = new boolean[n];
        col = new boolean[n];
        //主对角线 i-j+n
        dig1 = new boolean[2*n];
        //副对角线：i+j
        dig2 = new boolean[2*n];
        //预处理字符数组
        for(int i=0;i<n;i++){
            for(int j =0;j<n;j++){
                board[i][j] = '.';
            }
        }
        //
        work(0,n);
        return ret;
    }
    public void work(int i,int n){

        if(i == n){
            List<String> tmp = new ArrayList<>();
            for(char[] s:board){
                tmp.add(new String(s));
            }
            ret.add(tmp);
        }
        //在row_cnt这一行，枚举所有可能的列
        for(int j =0;j<n;j++){
            if(col[j] || dig1[i-j+n] || dig2[i+j]) continue;

            //如果能放那就放进去：
            board[i][j] = 'Q';
            col[j] = dig1[i-j+n] = dig2[i+j] = true;
            work(i+1,n);
            //回溯：
            board[i][j] = '.';
            col[j] = dig1[i-j+n] = dig2[i+j] = false;
        }
    }
}