public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        HashMap<ArrayList<Integer>, Boolean> mapA = new HashMap<ArrayList<Integer>, Boolean>(); 
        int len = num.length;
        int ele[] = new int[3];

        for (int Ele : num) {
            if (map.containsKey(Ele)) {
                int tmp = map.get(Ele);
                map.put(Ele, tmp + 1);
            } else
                map.put(Ele, 1);
        }

        for (int i = 0; i < len - 2; i++) {
            ele[0] = map.get(num[i]);
            if (ele[0] != 0) {
                map.put(num[i], ele[0] - 1);
                for (int j = i + 1; j < len; j++) {
                    ele[1] = map.get(num[j]);
                    if (ele[1] != 0) {
                        int target = (-1) * (num[i] + num[j]);
                        if (map.containsKey(target)) {
                            ele[2] = map.get(target);
                            if ((num[j] != target && ele[2] != 0) || (num[j] == target && ele[2] > 1)) {
                                ArrayList<Integer> ret = new ArrayList<Integer>();
                                ret.add(num[i]);
                                ret.add(num[j]);
                                ret.add(target);
                                Collections.sort(ret);
                                if (!mapA.containsKey(ret)) {
                                    ans.add(ret);
                                    mapA.put(ret, true);
                                }
                            }
                        }
                        
                    }
                }
            }
            map.put(num[i], 0);
        }

        return ans;
    }
    /*
    {-1, 0, 1, 2, -1, -4};
    {-2,0,0,2,2};
    {0, 0, 0};
    {1 ,0, -1, 1, 2, -1};
    */
}
