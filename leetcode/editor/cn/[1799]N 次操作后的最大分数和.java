//给你 nums ，它是一个大小为 2 * n 的正整数数组。你必须对这个数组执行 n 次操作。 
//
// 在第 i 次操作时（操作编号从 1 开始），你需要： 
//
// 
// 选择两个元素 x 和 y 。 
// 获得分数 i * gcd(x, y) 。 
// 将 x 和 y 从 nums 中删除。 
// 
//
// 请你返回 n 次操作后你能获得的分数和最大为多少。 
//
// 函数 gcd(x, y) 是 x 和 y 的最大公约数。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [1,2]
//输出：1
//解释：最优操作是：
//(1 * gcd(1, 2)) = 1
// 
//
// 示例 2： 
//
// 输入：nums = [3,4,6,8]
//输出：11
//解释：最优操作是：
//(1 * gcd(3, 6)) + (2 * gcd(4, 8)) = 3 + 8 = 11
// 
//
// 示例 3： 
//
// 输入：nums = [1,2,3,4,5,6]
//输出：14
//解释：最优操作是：
//(1 * gcd(1, 5)) + (2 * gcd(2, 4)) + (3 * gcd(3, 6)) = 1 + 4 + 9 = 14
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 7 
// nums.length == 2 * n 
// 1 <= nums[i] <= 10⁶ 
// 
//
// Related Topics 位运算 数组 数学 动态规划 回溯 状态压缩 数论 👍 64 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int n;
    int g[][];
    int dp[];
    public int maxScore(int[] nums) {
        n = nums.length;
        g = new int[n][n];
        dp = new int[1<<n];
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                g[i][j] = gcd(nums[i],nums[j]);
            }
        }
        int mask = (1 << n) - 1;
        return dfs(1,mask,0,nums);
    }
    public int dfs(int x,int mask,int sum,int[] nums){
        if(x == n / 2 + 1) return sum;
        if(dp[mask] > 0) return sum + dp[mask];
        int ans = 0;
        for(int i=0;i<n;i++){
            if(((1<<i) & mask) == 0) continue;
            for(int j=i+1;j<n;j++){
                if(((1<<j) & mask)==0) continue;
                int next = mask ^ (1 << i) ^ (1 << j);
                ans = Math.max(ans,dfs(x+1,next,sum + x * g[i][j],nums));
            }
        }
        dp[mask] = ans - sum;
        return ans;
    }

    public int gcd(int a,int b){
        return b == 0? a : gcd(b, a % b);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
