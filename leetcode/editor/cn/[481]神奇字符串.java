//神奇字符串 s 仅由 '1' 和 '2' 组成，并需要遵守下面的规则： 
//
// 
// 神奇字符串 s 的神奇之处在于，串联字符串中 '1' 和 '2' 的连续出现次数可以生成该字符串。 
// 
//
// s 的前几个元素是 s = "1221121221221121122……" 。如果将 s 中连续的若干 1 和 2 进行分组，可以得到 "1 22 11 
//2 1 22 1 22 11 2 11 22 ......" 。每组中 1 或者 2 的出现次数分别是 "1 2 2 1 1 2 1 2 2 1 2 2 ...
//..." 。上面的出现次数正是 s 自身。 
//
// 给你一个整数 n ，返回在神奇字符串 s 的前 n 个数字中 1 的数目。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 6
//输出：3
//解释：神奇字符串 s 的前 6 个元素是 “122112”，它包含三个 1，因此返回 3 。 
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 10⁵ 
// 
//
// Related Topics 双指针 字符串 👍 85 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int magicalString(int n) {

        if (n <= 3) return 1;

        StringBuilder s = new StringBuilder("122");
        int l = 2;
        int r = 2;
        while (s.length() < n) {
            char pre = s.charAt(r);
            if (s.charAt(l) == '1') {
                if (pre == '1') s.append('2');
                else {
                    s.append('1');
                }
            } else {
                if (pre == '1') s.append("22");
                else {
                    s.append("11");
                }
                r++;
            }
            l++;
            r++;
        }
        int ans = 0;
        for (int i=0;i<n;i++){
            if(s.charAt(i)=='1') ans++;
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
