import java.util.Hashtable;
public class Solution {
    public int longestConsecutive(int[] num) {
        int len = num.length;
        if (len == 0)
            return 0;
        Hashtable<Integer, Integer> hash = new Hashtable<Integer, Integer>();
        for (int i = 0; i < len; i++)
            hash.put(num[i], i);
        int[] visit = new int[len];
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            if (visit[i] == 1)
                continue;
            visit[i] = 1;
            int ret = 1, np = num[i];
            while (hash.containsKey(np - 1)) {
                int index = hash.get(np - 1);
                visit[index] = 1;
                ret++;
                np = num[index];
            }
            np = num[i];
            while (hash.containsKey(np + 1)) {
                int index = hash.get(np + 1);
                visit[index] = 1;
                ret++;
                np = num[index];
            }
            ans = Math.max(ans, ret);
        }
        return ans;
    }
}
