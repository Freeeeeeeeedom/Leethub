//给你三个正整数 n、index 和 maxSum 。你需要构造一个同时满足下述所有条件的数组 nums（下标 从 0 开始 计数）： 
//
// 
// nums.length == n 
// nums[i] 是 正整数 ，其中 0 <= i < n 
// abs(nums[i] - nums[i+1]) <= 1 ，其中 0 <= i < n-1 
// nums 中所有元素之和不超过 maxSum 
// nums[index] 的值被 最大化 
// 
//
// 返回你所构造的数组中的 nums[index] 。 
//
// 注意：abs(x) 等于 x 的前提是 x >= 0 ；否则，abs(x) 等于 -x 。 
//
// 
//
// 示例 1： 
//
// 输入：n = 4, index = 2,  maxSum = 6
//输出：2
//解释：数组 [1,1,2,1] 和 [1,2,2,1] 满足所有条件。不存在其他在指定下标处具有更大值的有效数组。
// 
//
// 示例 2： 
//
// 输入：n = 6, index = 1,  maxSum = 10
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= maxSum <= 10⁹ 
// 0 <= index < n 
// 
//
// Related Topics 贪心 二分查找 👍 78 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxValue(int n, int idx, int sum) {
        int l = 1, r = sum;
        while (l < r) {
            int mid = (l + r + 1) >> 1;
            if (-mid + get(mid, idx + 1) + get(mid, n - idx) <= sum) l = mid;
            else r = mid - 1;
        }
        return r;
    }
    long get(long mid, int cnt) {
        return cnt >= mid ? cnt - mid + (mid + 1) * mid / 2 : (2 * mid - cnt + 1) * cnt / 2;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
