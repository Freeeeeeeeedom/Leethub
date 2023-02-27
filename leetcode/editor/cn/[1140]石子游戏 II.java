//爱丽丝和鲍勃继续他们的石子游戏。许多堆石子 排成一行，每堆都有正整数颗石子 piles[i]。游戏以谁手中的石子最多来决出胜负。 
//
// 爱丽丝和鲍勃轮流进行，爱丽丝先开始。最初，M = 1。 
//
// 在每个玩家的回合中，该玩家可以拿走剩下的 前 X 堆的所有石子，其中 1 <= X <= 2M。然后，令 M = max(M, X)。 
//
// 游戏一直持续到所有石子都被拿走。 
//
// 假设爱丽丝和鲍勃都发挥出最佳水平，返回爱丽丝可以得到的最大数量的石头。 
//
// 
//
// 示例 1： 
//
// 
//输入：piles = [2,7,9,4,4]
//输出：10
//解释：如果一开始Alice取了一堆，Bob取了两堆，然后Alice再取两堆。爱丽丝可以得到2 + 4 + 4 = 10堆。如果Alice一开始拿走了两堆，那
//么Bob可以拿走剩下的三堆。在这种情况下，Alice得到2 + 7 = 9堆。返回10，因为它更大。
// 
//
// 示例 2: 
//
// 
//输入：piles = [1,2,3,4,5,100]
//输出：104
// 
//
// 
//
// 提示： 
//
// 
// 1 <= piles.length <= 100 
// 
// 1 <= piles[i] <= 10⁴ 
// 
//
// Related Topics 数组 数学 动态规划 博弈 👍 198 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int[][] cache;
    int[] sum;
    int N;
    public int stoneGameII(int[] piles) {
        N = piles.length;
        sum = new int[N+1];
        cache = new int[N][N];
        for(int i=N-1;i>=0;i--) sum[i] = sum[i+1] + piles[i];
        for(int i=0;i<N;i++) Arrays.fill(cache[i],-1);

        return dfs(0,1);
    }

    public int dfs(int k, int m){
        if(k + 2 * m >= N) return sum[k];
        if(cache[k][m]!=-1) return cache[k][m];

        int mn = Integer.MAX_VALUE;
        for(int i=1;i<=2*m;i++){
            mn = Math.min(mn,dfs(k+i,Math.max(m,i)));
        }
        return cache[k][m] = sum[k] - mn;
    }






    public int[] leftRigthDifference(int[] nums) {
        int n = nums.length;
        int[] leftsum = new int[n+1];
        int[] rightsum = new int[n+1];

        for(int i=0;i<n;i++) leftsum[i+1] = leftsum[i] + nums[i];
        for(int i=n-1;i>0;i--) rightsum[i] = rightsum[i+1] + nums[i];

        int[] ans = new int[n];
        for(int i=0;i<n;i++) ans[i] = Math.abs(leftsum[i-1] - rightsum[i+1]);
        return ans;
    }

    public int[] divisibilityArray(String word, int m) {
        char[] words = word.toCharArray();
        int n = words.length;

        int[] ans = new int[n];
        int val = 0;
        for(int i=0;i<n;i++){
            int t = words[i] - '0';
            val = (10 * val + t) % m;
            ans[i] = val == 0 ? 1 : 0;
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
