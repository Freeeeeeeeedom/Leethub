//给定一个按 非递减顺序 排列的数字数组
// digits 。你可以用任意次数 digits[i] 来写的数字。例如，如果
// digits = ['1','3','5']，我们可以写数字，如
// '13', '551', 和 '1351315'。 
//
// 返回 可以生成的小于或等于给定整数 n 的正整数的个数 。 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = ["1","3","5","7"], n = 100
//输出：20
//解释：
//可写出的 20 个数字是：
//1, 3, 5, 7, 11, 13, 15, 17, 31, 33, 35, 37, 51, 53, 55, 57, 71, 73, 75, 77.
// 
//
// 示例 2： 
//
// 
//输入：digits = ["1","4","9"], n = 1000000000
//输出：29523
//解释：
//我们可以写 3 个一位数字，9 个两位数字，27 个三位数字，
//81 个四位数字，243 个五位数字，729 个六位数字，
//2187 个七位数字，6561 个八位数字和 19683 个九位数字。
//总共，可以使用D中的数字写出 29523 个整数。 
//
// 示例 3: 
//
// 
//输入：digits = ["7"], n = 8
//输出：1
// 
//
// 
//
// 提示： 
// 
//
// 
// 1 <= digits.length <= 9 
// digits[i].length == 1 
// digits[i] 是从 '1' 到 '9' 的数 
// digits 中的所有值都 不同 
// digits 按 非递减顺序 排列 
// 1 <= n <= 10⁹ 
// 
//
// Related Topics 数组 数学 字符串 二分查找 动态规划 👍 153 👎 0


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int[] nums;
    int dp(int x){
        List<Integer> list = new ArrayList<>();
        while(x != 0){
            list.add(x % 10);
            x /= 10;
        }
        //存入list

        int n = list.size();
        int m = nums.length;
        int ans = 0;
//长度等于x的分情况计算
        for(int i=n-1;i>=0;i--){
            int cur = list.get(i);
            int l = 0;
            int r = m-1;
            while(l < r){
                int mid = l + r + 1>>1;
                if(nums[mid] <= cur) l = mid;
                else r = mid - 1;
            }
            //找到可填入的最大的index
            if(nums[r] > cur){
                break;
            }
            else if(nums[r] == cur){
                ans += r * (int)Math.pow(m,i);
                if(i == 0) ans++;
                //如果一直存在可相等的情况，那么相等情况均先加上不相等的情况，后续继续补上相等的情况即可
            }
            else{
                ans += (r+1)*(int)Math.pow(m,i);
                break;
                //出现这种情况，说明不可能出现和num相等的情况，直接结束运算了，后面的所有情况都已经考虑
            }
        }
//长度小于x的直接计算
        for(int i=1,last=1;i<n;i++){
            int cur = last * m;
            ans += cur;
            last = cur;
        }
        return ans;
    }
    public int atMostNGivenDigitSet(String[] _digits, int n) {
        int l = _digits.length;
        nums = new int[l];
        for(int i=0;i<l;i++) nums[i]=Integer.parseInt(_digits[i]);
        return dp(n);
    }

}
//leetcode submit region end(Prohibit modification and deletion)
