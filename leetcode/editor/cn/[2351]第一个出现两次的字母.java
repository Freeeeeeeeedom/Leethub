//给你一个由小写英文字母组成的字符串 s ，请你找出并返回第一个出现 两次 的字母。 
//
// 注意： 
//
// 
// 如果 a 的 第二次 出现比 b 的 第二次 出现在字符串中的位置更靠前，则认为字母 a 在字母 b 之前出现两次。 
// s 包含至少一个出现两次的字母。 
// 
//
// 
//
// 示例 1： 
//
// 输入：s = "abccbaacz"
//输出："c"
//解释：
//字母 'a' 在下标 0 、5 和 6 处出现。
//字母 'b' 在下标 1 和 4 处出现。
//字母 'c' 在下标 2 、3 和 7 处出现。
//字母 'z' 在下标 8 处出现。
//字母 'c' 是第一个出现两次的字母，因为在所有字母中，'c' 第二次出现的下标是最小的。
// 
//
// 示例 2： 
//
// 输入：s = "abcdd"
//输出："d"
//解释：
//只有字母 'd' 出现两次，所以返回 'd' 。
// 
//
// 
//
// 提示： 
//
// 
// 2 <= s.length <= 100 
// s 由小写英文字母组成 
// s 包含至少一个重复字母 
// 
//
// Related Topics 哈希表 字符串 计数 👍 20 👎 0


import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public char repeatedCharacter(String s) {
        char[] c = s.toCharArray();
        HashSet<Character> hs = new HashSet<>();
        for(int i=0;i<c.length;i++){
            if(!hs.contains(c[i])) hs.add(c[i]);
            else return c[i];
        }
        return c[c.length-1];
    }

    public int countDigits(int num) {
        int n = num;
        int ans = 0;
        while(n>0){
            int t = n%10;
            if(t!=0 && num%t==0) ans++;
            n /= 10;
        }
        return ans;
    }

    public int distinctPrimeFactors(int[] nums) {
        int ans = 0;
        int n = nums.length;
        HashSet<Integer> hs = new HashSet<>();
        for(int i=0;i<n;i++){
            hs.addAll(resolve(nums[i]));
        }
        return hs.size();
    }

    public ArrayList<Integer> resolve(int n){
        int k = 2;
        ArrayList<Integer> list = new ArrayList<>();
        while(n>=k){
            if(n==k){
                list.add(n); break;
            }
            else if(n != k && n%k==0){
                list.add(k); n/=k;
            }
            else k++;
        }
        return list;
    }


    public int minimumPartition(String s, int k) {
        char[] c = s.toCharArray();
        int n = c.length;
        int[] dp = new int[n+1];
        if(c[0]-'0'>k) return -1;
        dp[0] = 1;
        for(int i=1;i<n;i++){
            if(c[i]-'0' > k) return -1;
            dp[i] = Integer.MAX_VALUE;
            int l = i-1;
            int temp = c[i]-'0';
            while(l>=0 && temp < k){
                temp += Math.pow(10,i-l);
                l--;
            }
            System.out.println(l + " " + i + " "+ temp);
            for(int j=i-1;j>l;j--){
                dp[i] = Math.min(dp[i],dp[j] + 1);
            }
        }
        return dp[n-1];
    }

    public int[] closestPrimes(int left, int right) {
        int pre = Integer.MIN_VALUE;
        int[] ans = new int[2];
        int curdis = Integer.MAX_VALUE;
        for(int i=left;i<=right;i++){
            if(isPrime(i)){
                if(pre==Integer.MIN_VALUE) pre = i;
                else{
                    if(i - pre < curdis){
                        curdis = i - pre;
                        ans[0] = pre;
                        ans[1] = i;
                    }
                }
            }
        }
        return ans;
    }
    public  boolean isPrime(int number) {
        int count = 0;
        for(int i = 2; i < Math.sqrt(number); i++) {
            if((number%i) == 0) {
                count++;
            }
        }
        if(count == 0) {
            return true;
        } else {
            return false;
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)
