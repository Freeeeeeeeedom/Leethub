//给定数组 nums 和一个整数 k 。我们将给定的数组 nums 分成 最多 k 个相邻的非空子数组 。 分数 由每个子数组内的平均值的总和构成。 
//
// 注意我们必须使用 nums 数组中的每一个数进行分组，并且分数不一定需要是整数。 
//
// 返回我们所能得到的最大 分数 是多少。答案误差在 10⁻⁶ 内被视为是正确的。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [9,1,2,3,9], k = 3
//输出: 20.00000
//解释: 
//nums 的最优分组是[9], [1, 2, 3], [9]. 得到的分数是 9 + (1 + 2 + 3) / 3 + 9 = 20. 
//我们也可以把 nums 分成[9, 1], [2], [3, 9]. 
//这样的分组得到的分数为 5 + 2 + 6 = 13, 但不是最大值.
// 
//
// 示例 2: 
//
// 
//输入: nums = [1,2,3,4,5,6,7], k = 4
//输出: 20.50000
// 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 100 
// 1 <= nums[i] <= 10⁴ 
// 1 <= k <= nums.length 
// 
//
// Related Topics 数组 动态规划 前缀和 👍 253 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double largestSumOfAverages(int[] nums, int k) {
        int n = nums.length;
        double[][] dp = new double[n][k+1];
        double[] sum = new double[n];
        sum[0] = nums[0];
        dp[0][1] = sum[0];
        for(int i=1;i<n;i++){
            sum[i] = sum[i-1] + nums[i];
            dp[i][1] = sum[i]/(i+1);
        }

        //dp[i][j]表示下标为[0,i]的分割成j段的最大平均值和

        for(int j=2;j<=k;j++){
            for(int i=j-1;i<n;i++){
                //分割成j段，至少index=j-1;
//                System.out.println("index = " + i + " 分割成" + j + "段");
                for(int x=j-2;x<i;x++){
//                    System.out.println("i = " + i + " x = " + x);
//                    System.out.println(sum[i] + "  " + i);
//                    System.out.println(sum[x] + "  " + x);
                    dp[i][j] = Math.max(dp[i][j],dp[x][j-1]+(sum[i]-sum[x])/(i-x));
//                    System.out.println(dp[i][j]);
                }
            }
        }
        return dp[n-1][k];
    }


}
//leetcode submit region end(Prohibit modification and deletion)
