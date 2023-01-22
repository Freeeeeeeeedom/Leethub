//给你一个数组 nums ，数组中只包含非负整数。定义 rev(x) 的值为将整数 x 各个数字位反转得到的结果。比方说 rev(123) = 321 ， 
//rev(120) = 21 。我们称满足下面条件的下标对 (i, j) 是 好的 ： 
//
// 
// 0 <= i < j < nums.length 
// nums[i] + rev(nums[j]) == nums[j] + rev(nums[i]) 
// 
//
// 请你返回好下标对的数目。由于结果可能会很大，请将结果对 10⁹ + 7 取余 后返回。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [42,11,1,97]
//输出：2
//解释：两个坐标对为：
// - (0,3)：42 + rev(97) = 42 + 79 = 121, 97 + rev(42) = 97 + 24 = 121 。
// - (1,2)：11 + rev(1) = 11 + 1 = 12, 1 + rev(11) = 1 + 11 = 12 。
// 
//
// 示例 2： 
//
// 输入：nums = [13,10,35,24,76]
//输出：4
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// 0 <= nums[i] <= 10⁹ 
// 
//
// Related Topics 数组 哈希表 数学 计数 👍 85 👎 0


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    final int mod = (int) 1e9 + 7;
    public int countNicePairs(int[] nums) {
        int n = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();

        long ans = 0;
        for(int i=0;i<n;i++){
            map.put(count(nums[i]),map.getOrDefault(count(nums[i]),0) + 1);
        }
        for(int i : map.keySet()){
            long k = map.get(i);
            ans = (ans + (k * (k - 1))/2 ) % mod;
        }
        return (int) ans;
    }

    public int count(int n){
        int rev = 0;
        int val = n;
        while(val>0){
            rev *= 10;
            rev += val % 10;
            val /= 10;
        }
        return n - rev;
    }


    //T1
    public int getCommon(int[] nums1, int[] nums2) {
        int ans = -1;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int l = 0;
        int r = 0;
        while(nums1[l] != nums2[r] && l < nums1.length && r < nums2.length){
            if(nums1[l] < nums2[r]) l++;
            if(nums1[l] > nums2[r]) r++;
        }
        if(nums1[l]==nums2[r]) ans = nums1[l];
        return ans;
    }


    public long minOperations(int[] nums1, int[] nums2, int k) {
        int sum1 = 0;
        int sum2 = 0;
        for(int i=0;i<nums1.length;i++) sum1 += nums1[i];
        for(int i=0;i<nums2.length;i++) sum2 += nums2[i];
        if(sum1 != sum2) return -1;

        long add = 0;
        long sub = 0;
        for(int i=0;i<nums1.length;i++){
            if(nums1[i] > nums2[i]){
                if(nums1[i]-nums2[i] % k != 0) return -1;
                sub += nums1[i]-nums2[i] / k;
            }
            else if(nums1[i] < nums2[i]){
                if(nums2[i]-nums1[i] % k != 0) return -1;
                add += nums1[i]-nums2[i] / k;
            }
        }
        if(add == sub) return add;
        return -1;
    }

    long ans = 0;
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->{
            return nums2[a] < nums2[b];
        });
        long cur_sum = 0;
        traceBack(pq, cur_sum, 0, 0, k, nums1, nums2);
        return ans;
    }

    public void traceBack(PriorityQueue<Integer> pq, long sum, long curnum, int curindex, int k, int[] nums1, int[] nums2){
        if(curnum == k){
            ans = Math.max(ans,pq.peek() * sum);
            return;
        }
        if(curindex == nums1.length) return;

        traceBack(new PriorityQueue<>(pq,(a,b)->{return nums2[a] < nums2[b];}), sum, curnum, curindex+1, k, nums1, nums2);
        pq.add(nums2[curindex]);
        sum += nums1[curindex];
        traceBack(new PriorityQueue<>(pq,(a,b)->{return nums2[a] < nums2[b];}),sum, curnum + 1, curindex+1, k, nums1, nums2);
    }

    //T1
    public int alternateDigitSum(int n) {
        int ans = 0;
        boolean flag = true;
        while (n > 0) {
            if(flag) ans += n % 10;
            else ans -= n % 10;
            n /= 10;
        }
        return ans;
    }

    //T2
    public int[][] sortTheStudents(int[][] score, int k) {
        Arrays.sort(score,(a,b)->{
            return a[k] - b[k];
        });
        return score;
    }

    //T3
    public boolean makeStringsEqual(String s, String target) {
        int n = s.length();
        int count1 = 0;
        int count2 = 0;
        for(int i=0;i<n;i++){
            count1 += s.charAt(i) - '0';
            count2 += target.charAt(i) - '0';
        }
        if(count1 == 0) return count2 == 0;
        if(count2 < 1 || count2 > (count1 + (n - count1))) return false;
        return true;
    }
    // 0 0 -> 0 0
    // 1 1 -> 0 1
    // 1 0 -> 1 1

    //T4
    public int minCost(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = k;
        for(int i=1;i<=n;i++){
            //dp[i]以i结尾的minCost
            dp[i] = dp[i-1] + k;
            for(int j=0;j<i;j++){
                //计算dp[j] + ()
                HashMap<Integer,Integer> map = new HashMap<>();
                int count = 0;
                for(int p=j+1;p<=i;p++){
                    map.put(nums[p-1], map.getOrDefault(nums[p-1], 0) + 1);
                    if(map.getOrDefault(nums[p-1], 0) == 2) count += 2;
                    else if(map.getOrDefault(nums[p-1], 0) > 2) count++;
                }
                dp[i] = Math.min(dp[i], dp[j] + count + k);
            }
        }
        return dp[n];
    }

}
//leetcode submit region end(Prohibit modification and deletion)
