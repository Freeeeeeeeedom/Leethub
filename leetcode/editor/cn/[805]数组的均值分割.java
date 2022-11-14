//给定你一个整数数组
// nums 
//
// 我们要将
// nums 数组中的每个元素移动到 A 数组 或者 B 数组中，使得 A 数组和
// B 数组不为空，并且
// average(A) == average(B) 。 
//
// 如果可以完成则返回true ， 否则返回 false 。 
//
// 注意：对于数组
// arr , 
// average(arr) 是
// arr 的所有元素除以
// arr 长度的和。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [1,2,3,4,5,6,7,8]
//输出: true
//解释: 我们可以将数组分割为 [1,4,5,8] 和 [2,3,6,7], 他们的平均值都是4.5。
// 
//
// 示例 2: 
//
// 
//输入: nums = [3,1]
//输出: false
// 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 30 
// 0 <= nums[i] <= 10⁴ 
// 
//
// Related Topics 位运算 数组 数学 动态规划 状态压缩 👍 127 👎 0


import java.util.Arrays;
import java.util.HashSet;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean splitArraySameAverage(int[] nums) {
        //状态压缩的数组长度极限一般是20，超过了可能会超时
        //此题的本质：找出 nums的非空子集，使之avg相等
        int n = nums.length;
        if(n==1) return false;
        int m = n/2;
        long sum = Arrays.stream(nums).sum();
        Set<Integer>[] dp = new Set[m+1];
        for(int i=0;i<=m;i++) dp[i] = new HashSet<Integer>();
        dp[0].add(0);
        for(int num : nums){
            for(int i=m;i>=1;i--){
                //只需检索1-m个数能够构成 满足条件的子集
                for(int x : dp[i-1]){
                    int curr = x + num;
                    if(curr * n == sum * i) return true;
                    dp[i].add(curr);//能找到i个数之和等于curr
                }
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
