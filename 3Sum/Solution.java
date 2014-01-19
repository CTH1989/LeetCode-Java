public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        HashMap<ArrayList<Integer>, Boolean> map = new HashMap<ArrayList<Integer>, Boolean>(); 
        int len = num.length;
        
        Arrays.sort(num);
        
        for (int i = 0; i < len; i ++) {
            int j = i + 1;
            int k = len - 1;
            while (j < k) {
                int tmp = num[i] + num[j] + num[k];
                if (tmp == 0) {
                    ArrayList<Integer> ret = new ArrayList<Integer>();
                    ret.add(num[i]);
                    ret.add(num[j]);
                    ret.add(num[k]);
                    Collections.sort(ret);
                    if (!map.containsKey(ret)) {
                        ans.add(ret);
                        map.put(ret, true);
                    }
                    j ++;
                    k --;
                } else if (tmp > 0) {
                    k --;
                } else {
                    j ++;
                }
            }
        }
        
        return ans;
    }
    /*
    {-1, 0, 1, 2, -1, -4};
    {-2,0,0,2,2};
    {0, 0, 0};
    {1 ,0, -1, 1, 2, -1};
    {-2,0,1,1,2};
    */
}
