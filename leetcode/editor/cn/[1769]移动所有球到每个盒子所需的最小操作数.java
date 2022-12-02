//有 n 个盒子。给你一个长度为 n 的二进制字符串 boxes ，其中 boxes[i] 的值为 '0' 表示第 i 个盒子是 空 的，而 boxes[i]
// 的值为 '1' 表示盒子里有 一个 小球。 
//
// 在一步操作中，你可以将 一个 小球从某个盒子移动到一个与之相邻的盒子中。第 i 个盒子和第 j 个盒子相邻需满足 abs(i - j) == 1 。注意，
//操作执行后，某些盒子中可能会存在不止一个小球。 
//
// 返回一个长度为 n 的数组 answer ，其中 answer[i] 是将所有小球移动到第 i 个盒子所需的 最小 操作数。 
//
// 每个 answer[i] 都需要根据盒子的 初始状态 进行计算。 
//
// 
//
// 示例 1： 
//
// 输入：boxes = "110"
//输出：[1,1,3]
//解释：每个盒子对应的最小操作数如下：
//1) 第 1 个盒子：将一个小球从第 2 个盒子移动到第 1 个盒子，需要 1 步操作。
//2) 第 2 个盒子：将一个小球从第 1 个盒子移动到第 2 个盒子，需要 1 步操作。
//3) 第 3 个盒子：将一个小球从第 1 个盒子移动到第 3 个盒子，需要 2 步操作。将一个小球从第 2 个盒子移动到第 3 个盒子，需要 1 步操作。共
//计 3 步操作。
// 
//
// 示例 2： 
//
// 输入：boxes = "001011"
//输出：[11,8,5,4,3,4] 
//
// 
//
// 提示： 
//
// 
// n == boxes.length 
// 1 <= n <= 2000 
// boxes[i] 为 '0' 或 '1' 
// 
//
// Related Topics 数组 字符串 👍 40 👎 0


import jdk.internal.ref.CleanerFactory;

import java.util.ArrayList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] minOperations(String b) {
        int nums = 0;
        char[] boxes = b.toCharArray();
        int n = boxes.length;
        int[] ans = new int[n];

        for(int i=0;i<n;i++){
            if(boxes[i] == '1') nums++;
            if(boxes[i] == '1') ans[0] += i - 0;
        }//统计全移动到index=0处的次数之和
        int left = 0;
        if(boxes[0] == '1') left++;
        //left为当前下标左边的1的个数
        for(int i=1;i<n;i++){
            //前缀和遍历
            ans[i] = ans[i-1] + left - (nums - left);
            if(boxes[i] == '1') left++;
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
