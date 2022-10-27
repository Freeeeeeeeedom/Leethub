//给你一个整数数组 nums 和一个整数 k ，找出 nums 中和至少为 k 的 最短非空子数组 ，并返回该子数组的长度。如果不存在这样的 子数组 ，返回 
//-1 。 
//
// 子数组 是数组中 连续 的一部分。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//输入：nums = [1], k = 1
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2], k = 4
//输出：-1
// 
//
// 示例 3： 
//
// 
//输入：nums = [2,-1,2], k = 3
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁵ <= nums[i] <= 10⁵ 
// 1 <= k <= 10⁹ 
// 
//
// Related Topics 队列 数组 二分查找 前缀和 滑动窗口 单调队列 堆（优先队列） 👍 473 👎 0


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        long[] sums = new long[n+1];
        sums[0] = 0;
        for(int i=1;i<=n;i++) sums[i] += sums[i-1] + nums[i-1];

        int ans = Integer.MAX_VALUE;
        Deque<Integer> q = new ArrayDeque<>();
        for (int i=0;i<sums.length;i++){
            while(!q.isEmpty() && sums[i] <= sums[q.getLast()]) q.removeLast();
            while(!q.isEmpty() && sums[i]-sums[q.peek()] >= k) ans = Math.min(ans, i - q.poll());
            q.addLast(i);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}

//leetcode submit region end(Prohibit modification and deletion)
