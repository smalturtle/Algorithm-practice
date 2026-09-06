/**
 * 
 * 
 * 力扣-74搜索二位矩阵
 * 
 * 将二维问题，看成一维
 */


class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int l= 0,r = m * n;
        while(l < r){
            int mid = l+(r -l)/2;
            //找到在二维数组里的对应位置：
            int x = mid / n;
            int y = mid % n;
            if(matrix[x][y] <target){
                l = mid +1;
            }else if(matrix[x][y] >target){
                r = mid;
            }else return true;
        }
        return false;
    }
}