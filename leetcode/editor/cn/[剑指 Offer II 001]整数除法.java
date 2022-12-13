//给定两个整数 a 和 b ，求它们的除法的商 a/b ，要求不得使用乘号 '*'、除号 '/' 以及求余符号 '%' 。 
//
// 
//
// 注意： 
//
// 
// 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2 
// 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−2³¹, 2³¹−1]。本题中，如果除法结果溢出，则返回 231 − 1 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：a = 15, b = 2
//输出：7
//解释：15/2 = truncate(7.5) = 7
// 
//
// 示例 2： 
//
// 
//输入：a = 7, b = -3
//输出：-2
//解释：7/-3 = truncate(-2.33333..) = -2 
//
// 示例 3： 
//
// 
//输入：a = 0, b = 1
//输出：0 
//
// 示例 4： 
//
// 
//输入：a = 1, b = 1
//输出：1 
//
// 
//
// 提示: 
//
// 
// -2³¹ <= a, b <= 2³¹ - 1 
// b != 0 
// 
//
// 
//
// 注意：本题与主站 29 题相同：https://leetcode-cn.com/problems/divide-two-integers/ 
//
// 
//
// Related Topics 位运算 数学 👍 203 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int divide(int a, int b) {
        if(a==0) return 0;

        if(a == Integer.MIN_VALUE){
            if(b==1) return a;
            if(b==-1) return Integer.MAX_VALUE;
        }
        if(b == Integer.MIN_VALUE){
            if(a==b) return 1;
            return 0;
        }


        boolean isNeg = false;
        if(a > 0){
            a = -a;
            isNeg = !isNeg;
        }
        if(b > 0){
            b = -b;
            isNeg = !isNeg;
        }

        int l = 1, r = Integer.MAX_VALUE, ans = 0;
        while(l <= r){
            int mid = l + (r - l)/2;
            boolean check = quickAdd(b,mid,a);
            if(check){
                ans = mid;
                if(mid == Integer.MAX_VALUE) break;
                l = mid + 1;
            }
            else r = mid - 1;
        }
        return isNeg ? -ans : ans;
    }

    public boolean quickAdd(int y, int z, int x) {
        // x 和 y 是负数，z 是正数
        // 需要判断 z * y >= x 是否成立
        int result = 0, add = y;
        while (z != 0) {
            if ((z & 1) != 0) {
                // 需要保证 result + add >= x
                if (result < x - add) {
                    return false;
                }
                result += add;
            }
            if (z != 1) {
                // 需要保证 add + add >= x
                if (add < x - add) {
                    return false;
                }
                add += add;
            }
            // 不能使用除法
            z >>= 1;
        }
        return true;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
