//给定一个字符串 s ，通过将字符串 s 中的每个字母转变大小写，我们可以获得一个新的字符串。 
//
// 返回 所有可能得到的字符串集合 。以 任意顺序 返回输出。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "a1b2"
//输出：["a1b2", "a1B2", "A1b2", "A1B2"]
// 
//
// 示例 2: 
//
// 
//输入: s = "3z4"
//输出: ["3z4","3Z4"]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length <= 12 
// s 由小写英文字母、大写英文字母和数字组成 
// 
//
// Related Topics 位运算 字符串 回溯 👍 437 👎 0


import com.sun.source.tree.Tree;

import javax.swing.tree.TreeNode;
import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> ans = new ArrayList<>();
        traceback(s,ans,0);
        return ans;
    }
    public void traceback(String s,List<String> ans,int index){
        if(index == s.length()) return;
        if(Character.isDigit(s.charAt(index))){
            traceback(s,ans,index+1);
        }

        if(!ans.contains(s)) ans.add(s);
        traceback(s,ans,index+1);
        char i = s.charAt(index);
        if(i>='a' && i<='z'){
            i = Character.toUpperCase(i);
        }
        else i = Character.toLowerCase(i);
        String changed = s.substring(0,index)+i+s.substring(index+1);
        if(!ans.contains(changed)) ans.add(changed);
        traceback(changed,ans,index+1);
    }



}
//leetcode submit region end(Prohibit modification and deletion)
