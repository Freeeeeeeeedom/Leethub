//在一个 n x n 的矩阵 grid 中，除了在数组 mines 中给出的元素为 0，其他每个元素都为 1。mines[i] = [xi, yi]表示 
//grid[xi][yi] == 0 
//
// 返回 grid 中包含 1 的最大的 轴对齐 加号标志的阶数 。如果未找到加号标志，则返回 0 。 
//
// 一个 k 阶由 1 组成的 “轴对称”加号标志 具有中心网格 grid[r][c] == 1 ，以及4个从中心向上、向下、向左、向右延伸，长度为 k-1，
//由 1 组成的臂。注意，只有加号标志的所有网格要求为 1 ，别的网格可能为 0 也可能为 1 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入: n = 5, mines = [[4, 2]]
//输出: 2
//解释: 在上面的网格中，最大加号标志的阶只能是2。一个标志已在图中标出。
// 
//
// 示例 2： 
//
// 
//
// 
//输入: n = 1, mines = [[0, 0]]
//输出: 0
//解释: 没有加号标志，返回 0 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 500 
// 1 <= mines.length <= 5000 
// 0 <= xi, yi < n 
// 每一对 (xi, yi) 都 不重复 
// 
//
// Related Topics 数组 动态规划 👍 135 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        int len = mines.length;
        int[][][] dp = new int[n][n][4];//左 上 右 下
        int[][] cnt = new int[n][n];
        for (int[] mine : mines) cnt[mine[0]][mine[1]] = -1;
        int ans = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(cnt[i][j]<0){
                    dp[i][j][0] = 0;
                    dp[i][j][1] = 0;
                }
                else{
                    dp[i][j][0] = i>0?dp[i-1][j][0]+1:1;
                    dp[i][j][1] = j>0?dp[i][j-1][1]+1:1;
                }
                if(cnt[n-1-i][n-1-j]<0){
                    dp[n-i-1][n-j-1][2] = 0;
                    dp[n-i-1][n-j-1][3] = 0;
                }
                else{
                    dp[n-i-1][n-1-j][2] = i>0?dp[n-i][n-1-j][2]+1:1;
                    dp[n-1-i][n-1-j][3] = j>0?dp[n-1-i][n-j][3]+1:1;
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int[] d = dp[i][j];
                int t = Math.min(Math.min(d[0],d[1]),Math.min(d[2],d[3]));
                ans = Math.max(ans,t);
            }
        }

        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
