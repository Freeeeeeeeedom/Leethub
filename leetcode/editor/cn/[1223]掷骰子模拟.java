//有一个骰子模拟器会每次投掷的时候生成一个 1 到 6 的随机数。 
//
// 不过我们在使用它时有个约束，就是使得投掷骰子时，连续 掷出数字 i 的次数不能超过 rollMax[i]（i 从 1 开始编号）。 
//
// 现在，给你一个整数数组 rollMax 和一个整数 n，请你来计算掷 n 次骰子可得到的不同点数序列的数量。 
//
// 假如两个序列中至少存在一个元素不同，就认为这两个序列是不同的。由于答案可能很大，所以请返回 模 10^9 + 7 之后的结果。 
//
// 
//
// 示例 1： 
//
// 输入：n = 2, rollMax = [1,1,2,2,2,3]
//输出：34
//解释：我们掷 2 次骰子，如果没有约束的话，共有 6 * 6 = 36 种可能的组合。但是根据 rollMax 数组，数字 1 和 2 最多连续出现一次，所
//以不会出现序列 (1,1) 和 (2,2)。因此，最终答案是 36-2 = 34。
// 
//
// 示例 2： 
//
// 输入：n = 2, rollMax = [1,1,1,1,1,1]
//输出：30
// 
//
// 示例 3： 
//
// 输入：n = 3, rollMax = [1,1,1,2,2,3]
//输出：181
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 5000 
// rollMax.length == 6 
// 1 <= rollMax[i] <= 15 
// 
//
// Related Topics 数组 动态规划 👍 173 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //回溯
    //全排列 - 不符合个数

    //剩余次数，上一个筛子的值，上一个筛子的值出现的次数
    int[][][] dp;
    public static final long MOD = (long) 1e9 + 7;
    private int[] rollMax;
    private int top;
    public int dieSimulator(int n, int[] rollMax) {
        this.rollMax = rollMax;
        this.top = n;
        int m = rollMax.length;
        dp = new int[n][m][15];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; ++j)
                Arrays.fill(dp[i][j], -1); // -1 表示没有访问过

        long ans = 0;
        for(int i=0;i<m;++i)  ans += traceBack(1,i,rollMax[i]-1);
        return (int) (ans % MOD);
    }


    public int traceBack(int sum, int pre, int pre_count){
        if(sum == top) return 1;
       if(dp[sum][pre][pre_count]!=-1) return dp[sum][pre][pre_count];
        long res = 0;
        for(int i=0;i<rollMax.length;i++){
            if( i != pre) res += traceBack(sum+1, i,rollMax[i]-1);
            else if(pre_count>0) res += traceBack(sum+1,i,pre_count-1);
        }

        return dp[sum][pre][pre_count] = (int) (res % MOD);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
