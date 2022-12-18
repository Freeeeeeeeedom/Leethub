//给你一个整数数组 nums 和一个整数 k 。 nums 仅包含 0 和 1 。每一次移动，你可以选择 相邻 两个数字并将它们交换。 
//
// 请你返回使 nums 中包含 k 个 连续 1 的 最少 交换次数。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [1,0,0,1,0,1], k = 2
//输出：1
//解释：在第一次操作时，nums 可以变成 [1,0,0,0,1,1] 得到连续两个 1 。
// 
//
// 示例 2： 
//
// 输入：nums = [1,0,0,0,0,0,1,1], k = 3
//输出：5
//解释：通过 5 次操作，最左边的 1 可以移到右边直到 nums 变为 [0,0,0,0,0,1,1,1] 。
// 
//
// 示例 3： 
//
// 输入：nums = [1,1,0,1], k = 2
//输出：0
//解释：nums 已经有连续 2 个 1 了。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// nums[i] 要么是 0 ，要么是 1 。 
// 1 <= k <= sum(nums) 
// 
//
// Related Topics 贪心 数组 前缀和 滑动窗口 👍 76 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minMoves(int[] nums, int k) {
        int l = 0;
        int r = k;
        int n = nums.length;

        int sum = 0;
        for(int i=0;i<r;i++) sum+=nums[i];
        while(r<n){

        }
    }



    public int similarPairs(String[] words) {
        int n = words.length;
        int ans = 0;
        HashSet<Character>()[] hs = new HashSet<int>()[n];

        for(int i=0;i<n;i++){
            hs[i] = new HashSet<Character>();
            for(int j=0;j<words[i].length();j++){
                hs[i].add(words[i].charAt(j));
            }
        }

        for(int i=0;i<hs.length();i++){
            for(int j=i+1;j<hs.length;j++){
                if(hs[i].size()==hs[j].size()) ans++;
            }
        }

        return ans;

    }



    public int smallestValue(int n) {
        ArrayList<Integer> list = resolve(n);
        int ans = 0;
        if (list.size()==1) return list.get(0);
        for(int i=0;i<list.size();i++){
            ans+=list.get(i);
        }
        if(smallestValue(n) == ans) return ans;
        return smallestValue(ans);
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

    public boolean isPossible(int n, List<List<Integer>> edges) {
        int m = edges.size();
        int[] count = new int[n];
        int nums= 0;

        for(int i=0;i<m;i++){
            if(edges.get(i).get(0) == edges.get(i).get(1)) return false;
            int a = edges.get(i).get(0);
            int b = edges.get(i).get(1);
            count[a] ++;
            count[b] ++;
            if(count[a]%2==1) nums++;
            else nums--;
            if(count[b]%2==1) nums++;
            else nums--;
        }
        if(nums==0) return true;
        if(nums%2==1) return false;
        for(int i=0;i<n;i++){
            if(count[i]==n-1 && n-1 %2 ==1) return false;
        }
        return true;

    }

    public int[] cycleLengthQueries(int n, int[][] queries) {
        int m = queries.length;
        int[] ans = new int[m];
        for(int i=0;i<m;i++){
            int a = queries[i][0];
            int b = queries[i][1];
            String A = "";
            String B = "";
            while(a>1){
                if(a%2==1) A+='r';
                else A+='l';
                a/=2;
            }
            while(b>1){
                if(b%2==1) B+='r';
                else B+='l';
                b/=2;
            }

            int p = A.length() - 1;
            int q = B.length() - 1;
            while(p>=0 && q>=0 && A.charAt(p) == B.charAt(q)){
                p--;q--;
            }

            ans[i] = p + q + 1;
        }

        return ans;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
