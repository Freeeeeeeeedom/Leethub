//给你一个以字符串形式表述的 布尔表达式（boolean） expression，返回该式的运算结果。 
//
// 有效的表达式需遵循以下约定： 
//
// 
// "t"，运算结果为 True 
// "f"，运算结果为 False 
// "!(expr)"，运算过程为对内部表达式 expr 进行逻辑 非的运算（NOT） 
// "&(expr1,expr2,...)"，运算过程为对 2 个或以上内部表达式 expr1, expr2, ... 进行逻辑 与的运算（AND） 
// "|(expr1,expr2,...)"，运算过程为对 2 个或以上内部表达式 expr1, expr2, ... 进行逻辑 或的运算（OR） 
// 
//
// 
//
// 示例 1： 
//
// 输入：expression = "!(f)"
//输出：true
// 
//
// 示例 2： 
//
// 输入：expression = "|(f,t)"
//输出：true
// 
//
// 示例 3： 
//
// 输入：expression = "&(t,f)"
//输出：false
// 
//
// 示例 4： 
//
// 输入：expression = "|(&(t,f,t),!(t))"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= expression.length <= 20000 
// expression[i] 由 {'(', ')', '&', '|', '!', 't', 'f', ','} 中的字符组成。 
// expression 是以上述形式给出的有效表达式，表示一个布尔值。 
// 
//
// Related Topics 栈 递归 字符串 👍 79 👎 0


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean parseBoolExpr(String expression) {
        Deque<Character> nums = new ArrayDeque<>();
        Deque<Character> ops  = new ArrayDeque<>();
        //双栈 分别记录 boolean 和 操作符
        for(char c : expression.toCharArray()){
            if(c == ',') continue;
            else if(c == 't' || c == 'f') nums.addLast(c);
            else if(c == '|' || c == '!' || c == '&') ops.addLast(c);
            else if(c == '(') nums.addLast('-');//标识符
            else if(c == ')'){
                //说明需要出栈
                char op = ops.pollLast();
                char cur = ' ';
                while(!nums.isEmpty() && nums.peekLast() != '-'){
                    char top = nums.pollLast();
                    cur = cur == ' ' ? top : cal(top,cur,op);
                }
                if(op == '!') cur = cur == 't' ? 'f' : 't';
                nums.pollLast();
                nums.addLast(cur);
            }
        }
        return nums.peekLast() == 't';
    }

    char cal(char a, char b, char op){
        boolean x = a == 't', y = b == 't';
        boolean ans = op == '|' ? x | y : x & y;
        return ans ? 't' : 'f';
    }

}
//leetcode submit region end(Prohibit modification and deletion)
