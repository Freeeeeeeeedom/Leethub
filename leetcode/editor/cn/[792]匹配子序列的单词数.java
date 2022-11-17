//给定字符串 s 和字符串数组 words, 返回 words[i] 中是s的子序列的单词个数 。 
//
// 字符串的 子序列 是从原始字符串中生成的新字符串，可以从中删去一些字符(可以是none)，而不改变其余字符的相对顺序。 
//
// 
// 例如， “ace” 是 “abcde” 的子序列。 
// 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcde", words = ["a","bb","acd","ace"]
//输出: 3
//解释: 有三个是 s 的子序列的单词: "a", "acd", "ace"。
// 
//
// Example 2: 
//
// 
//输入: s = "dsahjpjauf", words = ["ahjpjau","ja","ahbwzgqnuk","tnmlanowax"]
//输出: 2
// 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length <= 5 * 10⁴ 
// 1 <= words.length <= 5000 
// 1 <= words[i].length <= 50 
// words[i]和 s 都只由小写字母组成。 
// 
//
//
// Related Topics 字典树 哈希表 字符串 排序 👍 243 👎 0


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        List<Integer>[] pos = new List[26];
        //每个字母用一个List来村春
        for(int i=0;i<26;i++) pos[i] = new ArrayList<Integer>();
        for(int i=0;i<s.length();i++) pos[s.charAt(i)-'a'].add(i);
        //list按顺序存储其出现的index
        int res = words.length;
        for(String w : words){
            if(w.length() > s.length()){
                --res;
                continue;
            }
            //剪枝
            int p = -1;
            for(int i=0;i<w.length();i++){
                char c = w.charAt(i);
                if(pos[c-'a'].isEmpty()||pos[c-'a'].get(pos[c-'a'].size()-1) <= p){
                    //该字符对应的list为空 或 list中的最后一个字符的index小于当前指向的字符
                    --res;
                    break;
                }
                p = binarySearch(pos[c-'a'],p);
                //在对应的list中（(p,end]中）搜索当前字符的最小index并更新p
            }
        }
        return res;

    }
    public int binarySearch(List<Integer> list,int target){
        int l = 0;
        int r = list.size()-1;
        while(l < r){
            int mid = l + r >> 1;
            if(list.get(mid) <= target) l = mid + 1;
            else r = mid;
        }
        return list.get(r);

    }
}

//leetcode submit region end(Prohibit modification and deletion)
