//给你一个整数数组 nums 和两个整数：left 及 right 。找出 nums 中连续、非空且其中最大元素在范围 [left, right] 内的子数组
//，并返回满足条件的子数组的个数。 
//
// 生成的测试用例保证结果符合 32-bit 整数范围。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,1,4,3], left = 2, right = 3
//输出：3
//解释：满足条件的三个子数组：[2], [2, 1], [3]
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,9,2,5,6], left = 2, right = 8
//输出：7
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// 0 <= nums[i] <= 10⁹ 
// 0 <= left <= right <= 10⁹ 
// 
//
// Related Topics 数组 双指针 👍 256 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        //Solution 1 单调栈
//        int n = nums.length;
//        int ans = 0;
//        int[] l = new int[n+10];
//        int[] r = new int[n+10];
//        Arrays.fill(l,-1);
//        Arrays.fill(r,n);
//        Deque<Integer> dq = new ArrayDeque<>();
//        for(int i=0;i<n;i++){
//            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) r[dq.pollLast()] = i;
//            dq.addLast(i);
//        }
//        dq.clear();
//        for(int i=n-1;i>=0;i--){
//            while(!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) l[dq.pollLast()] = i;
//            dq.addLast(i);
//        }
//        for(int i=0;i<n;i++){
//            if(nums[i] < left || nums[i] > right) continue;
//            ans += (i-l[i]) * (r[i] - i);
//        }
//        return ans;
        //Solution 2 模拟
        int n = nums.length;
        int j = -1;
        int k = -1;
        int ans = 0;
        for(int i=0;i<n;i++){
            if(nums[i]>right){
                k = i;
                continue;
            }
            if(nums[i]<left){
                if(j > k) ans += j-k;
            }else {
                ans += i - k;
                j = i;
            }
        }
        return ans;


    }
}
//leetcode submit region end(Prohibit modification and deletion)
