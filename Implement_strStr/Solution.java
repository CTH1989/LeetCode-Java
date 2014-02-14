public class Solution {
    public int[] compute_prefix_function(String P) {
        int m = P.length();
        int[] pi = new int[m];
        pi[0] = -1;
        int k = -1;
        for (int q = 1; q < m; q ++) {
            while (k >= 0 && P.charAt(k + 1) != P.charAt(q)) {
                k = pi[k];
            }
            if (P.charAt(k + 1) == P.charAt(q)) {
                k = k + 1;
            }
            pi[q] = k;
        }
        return pi;
    }
    public String strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();
        if (m == 0) return haystack;
        if (n == 0) return null;
        int[] pi = compute_prefix_function(needle);
        int q = -1;
        for (int i = 0; i < n; i ++) {
            while (q >= 0 && needle.charAt(q + 1) != haystack.charAt(i)) {
                q = pi[q];
            }
            if (needle.charAt(q + 1) == haystack.charAt(i)) {
                q = q + 1;
            }
            if (q == m - 1) return haystack.substring(i - m + 1);
        }
        return null;
    }
}
