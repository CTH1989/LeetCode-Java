public class Solution {
    public String getPermutation(int n, int k) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        for (int i = 1; i <= n; i ++)
            list.add(i);
        int tmp = 1, fact[] = new int[10];
        for (int i = 0; i < 10; i++) {
            if (i == 0)
                fact[i] = 1;
            else {
                tmp *= i;
                fact[i] = tmp;
            }
        }
        String ans = "";
        int np = n - 1;
        while (np > 0) {
            int ret = k / fact[np];
            int rem = k % fact[np];
            if (rem == 0)
                k = fact[np];
            else
                k = rem;
            if (rem == 0 && ret != 0)
                ret--;
            ans += list.get(ret);
            list.remove(ret);
            np--;
        }
        ans += list.get(0);
        return ans;
    }
}
