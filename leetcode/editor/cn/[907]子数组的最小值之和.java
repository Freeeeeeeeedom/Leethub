//给定一个整数数组 arr，找到 min(b) 的总和，其中 b 的范围为 arr 的每个（连续）子数组。 
//
// 由于答案可能很大，因此 返回答案模 10^9 + 7 。 
//
// 
//
// 示例 1： 
//
// 
//输入：arr = [3,1,2,4]
//输出：17
//解释：
//子数组为 [3]，[1]，[2]，[4]，[3,1]，[1,2]，[2,4]，[3,1,2]，[1,2,4]，[3,1,2,4]。 
//最小值为 3，1，2，4，1，1，2，1，1，1，和为 17。 
//
// 示例 2： 
//
// 
//输入：arr = [11,81,94,43,3]
//输出：444
// 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 3 * 10⁴ 
// 1 <= arr[i] <= 3 * 10⁴ 
// 
//
// 
//
// Related Topics 栈 数组 动态规划 单调栈 👍 485 👎 0


import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int MOD = (int)1e9 + 7;
        int ans = 0;

        int[] l = new int[n], r = new int[n];
        Arrays.fill(l,-1);
        Arrays.fill(r,n);
        Deque<Integer> d = new ArrayDeque<>();

        for(int i=0;i<n;i++){
            int cur = arr[i];
            while(!d.isEmpty() && cur <= arr[d.peekLast()]){
                r[d.pollLast()] = i;
            }
            d.addLast(i);
            //d是一个单调增栈，那么如果d中元素出栈，则说明此时的i是该元素右边第一个比他小的
        }
        d.clear();
        for(int i=n-1;i>=0;i--){
            int cur = arr[i];
            while(!d.isEmpty() && cur < arr[d.peekLast()]){
                l[d.pollLast()] = i;
            }
            d.addLast(i);
        }
        d.clear();

        for(int i=0;i<n;i++){
            int a = i - l[i];
            int b = r[i] - i;
            ans += (long) a * b % MOD * arr[i] % MOD;
            ans %= MOD;
        }
        return ans;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
