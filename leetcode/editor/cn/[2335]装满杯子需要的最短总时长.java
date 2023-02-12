//现有一台饮水机，可以制备冷水、温水和热水。每秒钟，可以装满 2 杯 不同 类型的水或者 1 杯任意类型的水。 
//
// 给你一个下标从 0 开始、长度为 3 的整数数组 amount ，其中 amount[0]、amount[1] 和 amount[2] 分别表示需要装满冷
//水、温水和热水的杯子数量。返回装满所有杯子所需的 最少 秒数。 
//
// 
//
// 示例 1： 
//
// 输入：amount = [1,4,2]
//输出：4
//解释：下面给出一种方案：
//第 1 秒：装满一杯冷水和一杯温水。
//第 2 秒：装满一杯温水和一杯热水。
//第 3 秒：装满一杯温水和一杯热水。
//第 4 秒：装满一杯温水。
//可以证明最少需要 4 秒才能装满所有杯子。
// 
//
// 示例 2： 
//
// 输入：amount = [5,4,4]
//输出：7
//解释：下面给出一种方案：
//第 1 秒：装满一杯冷水和一杯热水。
//第 2 秒：装满一杯冷水和一杯温水。
//第 3 秒：装满一杯冷水和一杯温水。
//第 4 秒：装满一杯温水和一杯热水。
//第 5 秒：装满一杯冷水和一杯热水。
//第 6 秒：装满一杯冷水和一杯温水。
//第 7 秒：装满一杯热水。
// 
//
// 示例 3： 
//
// 输入：amount = [5,0,0]
//输出：5
//解释：每秒装满一杯冷水。
// 
//
// 
//
// 提示： 
//
// 
// amount.length == 3 
// 0 <= amount[i] <= 100 
// 
//
// Related Topics 贪心 数组 排序 堆（优先队列） 👍 48 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int fillCups(int[] amount) {
        Arrays.sort(amount);
        int a = amount[0];
        int b = amount[1];
        int c = amount[2];
        if(a + b <= c) return c;
        return c + (a + b - c + 1)/2;
    }

    //T1
    public long findTheArrayConcVal(int[] nums) {
        int n = nums.length;
        int l = 0;
        int r = n-1;
        long ans = 0;
        while(l < r){
            int val = Integer.parseInt(String.valueOf(nums[l]) + String.valueOf(nums[r]));
            ans += val;
            l ++;
            r --;
        }
        return ans;
    }
    // >=
    public int l_s(int[] nums,int target){
        int l = 0;
        int r = nums.length-1;
        while(l < r){
            int mid = l + r + 1>>1;
            if(nums[mid] >= target) r = mid;
            else l++;
        }
        return l;
    }
    // >
    public int r_s(int[] nums,int target){
        int l = 0;
        int r = nums.length-1;
        while(l < r){
            int mid = l + r + 1>>1;
            if(nums[mid] > target) r = mid;
            else l++;
        }
        return r;
    }
    //T2
    public long countFairPairs(int[] nums, int lower, int upper) {
        int n = nums.length;
        Arrays.sort(nums);
        long ans = 0;

        for(int i=0;i<n-1;i++){
            int val = nums[i];
            int min = lower - val;
            int max = upper - val;
           int l = l_s(nums,min);
           int r = r_s(nums,min);
           ans += r - l + 1;
        }
        return ans;
    }

    private final static int[] NOT_FOUND = new int[]{-1,-1};

    public int[][] substringXorQueries(String S, int[][] queries){
        var s = S.toCharArray();
        var m = new HashMap<Integer,int[]>();
        for(int l=0, n = s.length; l < n; l++){
            for(int r=l,x=0;r<Math.min(l+30,n);r++){
                x = x<<1 | (s[r] & 1);
                if(!m.)
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
