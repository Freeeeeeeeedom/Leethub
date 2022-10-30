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

    //First
    public int averageValue(int[] nums) {
        int n = nums.length;
        long sum = 0 ;
        int size = 0;
        for(int i=0;i<n;i++){
            if(nums[i]%6==0){
                sum+=nums[i];
                size++;
            }

        }
        if(size==0) return 0;
        return (int)sum/size;
    }
    //Second
    public List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
        List<List<String>> ans = new ArrayList<>();
        int n = creators.length;
        int m = ids.length;

        HashMap<String,String> max = new HashMap<>();
        HashMap<String,Integer> mapofctov = new HashMap<>();
        HashMap<String,Integer> mp = new HashMap<>();
        for(int i=0;i<n;i++){
            String creator = creators[i];
            if(mp.containsKey(creator)){
                if(mapofctov.get(creator) < views[i]){
                    max.put(creator,ids[i]);
                    mapofctov.put(creator,views[i]);
                }
                else if(mapofctov.get(creator) == views[i]){
                    if(ids[i].compareTo(max.get(creator)) < 0){
                        max.put(creator,ids[i]);
                        mapofctov.put(creator,views[i]);
                    }
                }
                mp.put(creator,mp.get(creator)+views[i]);
            }
            else {mp.put(creator,views[i]); max.put(creator,ids[i]);mapofctov.put(creator,views[i]);}
        }
        //每个creator和他的流量总和
        List<Map.Entry<String,Integer>> entrys = new ArrayList<>(mp.entrySet());
        Collections.sort(entrys, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue() - o2.getValue();
            }
        });

        List<String > temp = new ArrayList<>();
        temp.add(entrys.get(mp.size()-1).getKey());
        int start = mp.size()-2;
        while(start>=0 && Objects.equals(entrys.get(start).getValue(), entrys.get(mp.size() - 1).getValue())){temp.add(entrys.get(start).getKey());start--;}

        for(int i=0;i<temp.size();i++){
            String crea = temp.get(i);
            String id = max.get(crea);
            List<String> t = new ArrayList<>();
            t.add(crea);t.add(id);
            ans.add(t);
        }
        return ans;


    }
    //Third
    public long makeIntegerBeautiful(long n, int target) {
        long val = n;
        if(check(n,target)) return 0;
        int index = 1;
        while(!check(val,target)){
            val /= Math.pow(10,index);
            val += 1;
            val *= Math.pow(10,index);
            index++;
        }
        return val - n;
    }
    public boolean check(long a,int target){
        int val = 0;
        while(a > 0){
            val += a%10;
            a/=10;
        }
        return val <= target;
    }

    //Fourth
    public int[] treeQueries(TreeNode root, int[] queries) {
        int m = queries.length;
        for(int i=0;i<m;i++){
            int node = queries[i];
            query(node,root);
            queries[i] = height(root);
        }
        return queries;
    }
    TreeNode flagl;
    TreeNode flagroot;
    boolean lorr = true;
    public int height(TreeNode root){
        int ans = 0;
        int height_l = 0;
        int height_r = 0;
        if(root == null){
            ans = 0;
            return ans;
        }

        height_l = height(root.left);
        height_r = height(root.right);

        ans = 1 + (height_l > height_r ? height_l : height_r);
        return ans;
    }
    public void query(int node, TreeNode root){
        if(root == null) return;
        TreeNode l = root.left;
        TreeNode r = root.right;
        if(l.val == node){ flagl = root.left; flagroot = root; root.left = null;}
        else if(r.val == node){flagl = root.right; flagroot =root;lorr= false; root.right = null;}
        else{
            query(node,l);
            query(node,r);
        }
        return;
    }
    public void reset(){
        if(lorr){
            flagroot.left = flagl;
        }
        else flagroot.right = flagl;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
