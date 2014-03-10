public class Solution {
    public void nextPermutation(int[] num) {
        int i, j, len = num.length;
        int ni = len, nj = -1;
        for (i = len - 1; i >= 0; i--) {
            for (j = i - 1; j >= 0; j--) {
                if (num[i] > num[j])
                    break;
            }
            if (j >= 0) {
                if (j > nj) {
                    ni = i;
                    nj = j;
                }
            }
        }
        if (nj == -1)
            Arrays.sort(num);
        else {
            int tmp = num[nj];
            num[nj] = num[ni];
            num[ni] = tmp;
            Arrays.sort(num, nj + 1, len);
        }
    }
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        int tot = 1, len = num.length;
        if (len == 0)
            return ans;
        for (int i = 1; i <= len; i ++)
            tot *= i;
        while (tot > 0) {
            ArrayList<Integer> ret = new ArrayList<Integer>();
            for (int i = 0; i < len; i++)
                ret.add(num[i]);
            ans.add(ret);
            tot--;
            nextPermutation(num);
        }
        return ans;
    }
}
