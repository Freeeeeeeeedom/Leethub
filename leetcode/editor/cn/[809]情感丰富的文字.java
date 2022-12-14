//有时候人们会用重复写一些字母来表示额外的感受，比如 "hello" -> "heeellooo", "hi" -> "hiii"。我们将相邻字母都相同的一串
//字符定义为相同字母组，例如："h", "eee", "ll", "ooo"。 
//
// 对于一个给定的字符串 S ，如果另一个单词能够通过将一些字母组扩张从而使其和 S 相同，我们将这个单词定义为可扩张的（stretchy）。扩张操作定义如下
//：选择一个字母组（包含字母 c ），然后往其中添加相同的字母 c 使其长度达到 3 或以上。 
//
// 例如，以 "hello" 为例，我们可以对字母组 "o" 扩张得到 "hellooo"，但是无法以同样的方法得到 "helloo" 因为字母组 "oo" 
//长度小于 3。此外，我们可以进行另一种扩张 "ll" -> "lllll" 以获得 "helllllooo"。如果 s = "helllllooo"，那么查询词
// "hello" 是可扩张的，因为可以对它执行这两种扩张操作使得 query = "hello" -> "hellooo" -> "helllllooo" = 
//s。 
//
// 输入一组查询单词，输出其中可扩张的单词数量。 
//
// 
//
// 示例： 
//
// 
//输入： 
//s = "heeellooo"
//words = ["hello", "hi", "helo"]
//输出：1
//解释：
//我们能通过扩张 "hello" 的 "e" 和 "o" 来得到 "heeellooo"。
//我们不能通过扩张 "helo" 来得到 "heeellooo" 因为 "ll" 的长度小于 3 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length, words.length <= 100 
// 1 <= words[i].length <= 100 
// s 和所有在 words 中的单词都只由小写字母组成。 
// 
//
// Related Topics 数组 双指针 字符串 👍 83 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int expressiveWords(String s, String[] words) {
        int n = words.length;
        int count = 0;
        for(int i=0;i<n;i++){
            if(check(s.toCharArray(),words[i].toCharArray())) count++;
        }
        return count;
    }

    public boolean check(char[] t,char[] s){
        int n = s.length;
        int m = t.length;
//        if(s.length > t.length) return false;
        int i = 0, j = 0;
//        System.out.println(Arrays.toString(s));
        while(i < n && j < m){
            if(s[i] != t[j]) return false;
            int old_i = i;
            while(i<n && s[i] == s[old_i]) i++;
            int old_j = j;
            while(j<m && t[j] == t[old_j]) j++;

            int diff = (j - old_j) - (i - old_i);

            if(diff < 0) return false;
            if(j-old_j==2 && diff!=0) return false;
//            System.out.println(diff);
//            System.out.println(diff);
        }
        if(j == m && i == n) return true;
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
