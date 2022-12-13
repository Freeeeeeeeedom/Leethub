//给定两个 01 字符串 a 和 b ，请计算它们的和，并以二进制字符串的形式输出。 
//
// 输入为 非空 字符串且只包含数字 1 和 0。 
//
// 
//
// 示例 1: 
//
// 
//输入: a = "11", b = "10"
//输出: "101" 
//
// 示例 2: 
//
// 
//输入: a = "1010", b = "1011"
//输出: "10101" 
//
// 
//
// 提示： 
//
// 
// 每个字符串仅由字符 '0' 或 '1' 组成。 
// 1 <= a.length, b.length <= 10^4 
// 字符串如果不是 "0" ，就都不含前导零。 
// 
//
// 
//
// 
// 注意：本题与主站 67 题相同：https://leetcode-cn.com/problems/add-binary/ 
//
// Related Topics 位运算 数学 字符串 模拟 👍 52 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String addBinary(String a, String b) {
        int n = a.length();
        int m = b.length();
        if(n < m) return addBinary(b,a);
        if(b.length()==0) return a;
        for(int i=0;i<n-m;i++) b = '0' + b;
        int carry  = 0;
        StringBuilder ans = new StringBuilder();
        for(int i = 0;i < n;i++){
            int idx = n - i - 1;
            int temp = carry + (a.charAt(idx) - '0') + (b.charAt(idx) - '0');
            if(temp <= 1){
                carry = 0;
                ans.append(temp);
            }
            else{
                carry = 1;
                temp -= 2;
                ans.append(temp);
            }
        }
        if(carry == 1) ans.append('1');

        return ans.reverse().toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
