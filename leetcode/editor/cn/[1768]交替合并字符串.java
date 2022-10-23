//给你两个字符串 word1 和 word2 。请你从 word1 开始，通过交替添加字母来合并字符串。如果一个字符串比另一个字符串长，就将多出来的字母追加到
//合并后字符串的末尾。 
//
// 返回 合并后的字符串 。 
//
// 
//
// 示例 1： 
//
// 
//输入：word1 = "abc", word2 = "pqr"
//输出："apbqcr"
//解释：字符串合并情况如下所示：
//word1：  a   b   c
//word2：    p   q   r
//合并后：  a p b q c r
// 
//
// 示例 2： 
//
// 
//输入：word1 = "ab", word2 = "pqrs"
//输出："apbqrs"
//解释：注意，word2 比 word1 长，"rs" 需要追加到合并后字符串的末尾。
//word1：  a   b 
//word2：    p   q   r   s
//合并后：  a p b q   r   s
// 
//
// 示例 3： 
//
// 
//输入：word1 = "abcd", word2 = "pq"
//输出："apbqcd"
//解释：注意，word1 比 word2 长，"cd" 需要追加到合并后字符串的末尾。
//word1：  a   b   c   d
//word2：    p   q 
//合并后：  a p b q c   d
// 
//
// 
//
// 提示： 
//
// 
// 1 <= word1.length, word2.length <= 100 
// word1 和 word2 由小写英文字母组成 
// 
//
// Related Topics 双指针 字符串 👍 41 👎 0


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int n = word1.length();
        int m = word2.length();

        for (int i = 0; i < Math.min(n, m); i++) {
            sb.append(word1.charAt(i));
            sb.append(word2.charAt(i));
        }
        if (n > m) {
            sb.append(word1, m, n);
        } else sb.append(word2, n, m);
        return sb.toString();
    }
    public boolean haveConflict(String[] event1, String[] event2) {
        int start1 = Integer.valueOf(event1[0].substring(0,2) + event1[0].substring(3,5));
        int start2 = Integer.valueOf(event2[0].substring(0,2) + event2[0].substring(3,5));
        int end1   = Integer.valueOf(event1[1].substring(0,2) + event1[1].substring(3,5));
        int end2   = Integer.valueOf(event2[1].substring(0,2) + event2[1].substring(3,5));
        if(start2 > end1 || start1 > end2) return false;
        return true;
    }

    public int subarrayGCD(int[] nums, int k) {
        int n = nums.length;
        int[][] dp = new int[n][n];
        int ans = 0;
        for(int i=0;i<n;i++){
            dp[i][i] = nums[i];
            if(dp[i][i] == k) ans++;
            for(int j=i+1;j<n;j++){
                int cur = nums[j];
                if(cur == dp[i][j-1]) dp[i][j] = cur;
                else if(dp[i][j-1] > cur) dp[i][j] = gcd(cur,dp[i][j-1]);
                else if(dp[i][j-1] < cur) dp[i][j] = gcd(cur,dp[i][j-1]);

                if(dp[i][j]==k) ans++;
            }
        }
        return ans;
    }

    public int gcd(int a,int b){
        while(b!=0){
            int r = b;
            b = a % b;
            a = r;
        }
        return a;
    }

    //3
    public long minCost(int[] nums, int[] cost) {
        int n = nums.length;
        List<int[]> list = new ArrayList<>();
        int[][] table = new int[n][2];
        for(int i=0;i<n;i++){table[i][0]=nums[i];table[i][1]=cost[i];list.add(table[i]);}
        Collections.sort(list, Comparator.comparingInt(a -> a[0]));

        long COST = 0;
        long MIN = 0;
        for(int i=0;i<n;i++){
            MIN = COST += 
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
