import java.util.HashMap;
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i, len = numbers.length;
        int[] res = new int[3];
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (i = 0; i < len; i++) {
            if (!map.containsKey(numbers[i])) {
                map.put(numbers[i], i);
            }
        }
        for (i = 0; i < len; i++) {
            int index1, index2;
            if (map.containsKey(target - numbers[i])) {
                index1 = i;
                index2 = map.get(target - numbers[i]);
                if (index1 > index2) {
                    int tmp = index1;
                    index1 = index2;
                    index2 = tmp;
                    res[0] = index1 + 1;
                    res[1] = index2 + 1;
                    return res;
                }
            }
        }
        return res;
    }
}
