public class Solution {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        int len = num.length;
        if (len == 0)
            return new ArrayList<ArrayList<Integer>>();
        Arrays.sort(num);
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        ans.add(new ArrayList<Integer>());
        for (int i = 0; i < len;) {
            int size = ans.size();
            int count = 0;
            for (int j = i; j < len; j++)
                if (num[i] == num[j])
                    count++;
                else
                    break;
            for (int j = 0; j < size; j++) {
                ArrayList<Integer> np = (ArrayList<Integer>) ans.get(j).clone();
                for (int k = 0; k < count; k++) {
                    np.add(num[i]);
                    ArrayList<Integer> pp = (ArrayList<Integer>) np.clone();
                    ans.add(pp);
                }
            }
            i += count;
        }
        return ans;
    }
}
