public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        if (len == 0)
            return -1;
        int[] arr = new int[len];
        for (int i = 0; i < len; i++)
            arr[i] = gas[i] - cost[i];
        for (int i = 0; i < len; i++) {
            if (arr[i] >= 0) {
                int tot = arr[i], start = i, np = (i + 1) % len;
                while (np != start) {
                    tot += arr[np];
                    if (tot < 0)
                        break;
                    np += 1;
                    np %= len;
                }
                if (np == start)
                    return start;
                if (np > i)
                    i = np;
                else
                    break;
            }
        }
        return -1;
    }
}
