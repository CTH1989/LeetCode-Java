public class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        int len = num.length, np = 0;
        int[] arr = new int[len * len];
        HashMap<Integer, ArrayList<ArrayList<Integer>>> map = new HashMap<Integer, ArrayList<ArrayList<Integer>>>();
        HashMap<ArrayList<Integer>, Boolean> hash = new HashMap<ArrayList<Integer>, Boolean>();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                int tmp = num[i] + num[j];
                ArrayList<Integer> ret = new ArrayList<Integer>();
                ret.add(i);
                ret.add(j);
                if (map.containsKey(tmp)) {
                    ArrayList<ArrayList<Integer>> list = map.get(tmp);
                    list.add(ret);
                } else {
                    arr[np++] = tmp;
                    ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
                    list.add(ret);
                    map.put(tmp, list);
                }
            }
        }

        Arrays.sort(arr, 0, np);
        
        int head = 0, tail = np - 1;
        while (head <= tail) {
            int tmp = arr[head] + arr[tail];
            if (tmp == target) {
                for (ArrayList<Integer> Ele : map.get(arr[head])) {
                    for (ArrayList<Integer> ele : map.get(arr[tail])) {
                        if (!Ele.contains(ele.get(0))
                                && !Ele.contains(ele.get(1))) {
                            ArrayList<Integer> ret = new ArrayList<Integer>();
                            ret.add(num[Ele.get(0)]);
                            ret.add(num[Ele.get(1)]);
                            ret.add(num[ele.get(0)]);
                            ret.add(num[ele.get(1)]);
                            Collections.sort(ret);
                            if (!hash.containsKey(ret)) {
                                hash.put(ret, true);
                                ans.add(ret);
                            }
                        }
                    }
                }
                head++;
                tail--;
            } else if (tmp < target) {
                head++;
            } else {
                tail--;
            }
        }

        return ans;
    }
}
