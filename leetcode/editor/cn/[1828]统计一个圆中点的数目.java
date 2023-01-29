//给你一个数组 points ，其中 points[i] = [xi, yi] ，表示第 i 个点在二维平面上的坐标。多个点可能会有 相同 的坐标。 
//
// 同时给你一个数组 queries ，其中 queries[j] = [xj, yj, rj] ，表示一个圆心在 (xj, yj) 且半径为 rj 的圆。 
//
//
// 对于每一个查询 queries[j] ，计算在第 j 个圆 内 点的数目。如果一个点在圆的 边界上 ，我们同样认为它在圆 内 。 
//
// 请你返回一个数组 answer ，其中 answer[j]是第 j 个查询的答案。 
//
// 
//
// 示例 1： 
// 输入：points = [[1,3],[3,3],[5,3],[2,2]], queries = [[2,3,1],[4,3,1],[1,1,2]]
//输出：[3,2,2]
//解释：所有的点和圆如上图所示。
//queries[0] 是绿色的圆，queries[1] 是红色的圆，queries[2] 是蓝色的圆。
// 
//
// 示例 2： 
// 输入：points = [[1,1],[2,2],[3,3],[4,4],[5,5]], queries = [[1,2,2],[2,2,2],[4,3,
//2],[4,3,3]]
//输出：[2,3,2,4]
//解释：所有的点和圆如上图所示。
//queries[0] 是绿色的圆，queries[1] 是红色的圆，queries[2] 是蓝色的圆，queries[3] 是紫色的圆。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= points.length <= 500 
// points[i].length == 2 
// 0 <= xi, yi <= 500 
// 1 <= queries.length <= 500 
// queries[j].length == 3 
// 0 <= xj, yj <= 500 
// 1 <= rj <= 500 
// 所有的坐标都是整数。 
// 
//
// Related Topics 几何 数组 数学 👍 36 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] countPoints(int[][] points, int[][] queries) {
            int n = points.length;
            int m = queries.length;

            int[] ans = new int[m];
            for(int i=0;i<m;i++){
                int x = queries[i][0];
                int y = queries[i][1];
                int r = queries[i][2];

                for(int j=0;j<n;j++){
                    int px = points[j][0];
                    int py = points[j][1];
                    if(check(px,py,r,x,y)) ans[i]++;
                }
            }
            return ans;
    }

    public boolean check(int x1,int y1,int r,int x0,int y0){
        if((x1-x0) * (x1-x0) + (y1-y0) * (y1-y0) <= r * r) return true;
        return false;
    }



    public int distinctIntegers(int n) {

    }

    int mod = 1000000007;
    public int monkeyMove(int n) {
        BigInteger fir = new BigInteger(2);
        BigInteger ans = fir.modPow(n,mod);
        return Integer.valueOf(ans) - 2;
    }

    public long putMarbles(int[] weights, int k) {
        int n = weights.length;
        if(n == 2) return 0;
        long maxweight = 0;
        long minweight = 0;


    }

    public long maxWeight(int[] weights, int k){
        int n = weights.length;
        HashSet<Integer> hs = new HashSet<>();
        for(int i=0;i<n;i++){
            hs.add(i);

        }


    }

    public long countQuadruplets(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n+10][n+10];
        for(int i=1;i<=n;i++) dp[i][1] = 1;
        for(int i=1;i<=n;i++){
            for(int k=1;k<i;k++){
                if(nums[i-1]> nums[k-1]) dp[i][1] += dp[k][0];
            }
            for(int k=1;k<i;k++){
                if(nums[i-1]> nums[k-1]) dp[i][2] += dp[k][1];
            }
            for(int k=1;k<i;k++){
                if(nums[i-1]> nums[k-1]) dp[i][3] += dp[k][2];
            }
            for(int k=1;k<i;k++){
                if(nums[i-1]> nums[k-1]) dp[i][4] += dp[k][3];
            }
        }
        long ans = 0;
        for(int i=1;i<=n;i++){
            ans += dp[i][4];
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
