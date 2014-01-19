public class Solution {
    public int romanToInt(String s) {
        int N[] = { 1000, 500, 100, 50, 10, 5, 1 };
        char C[] = { 'M', 'D', 'C', 'L', 'X', 'V', 'I', ' ' };
        char strArr[] = s.toCharArray();
        int len = s.length(), tmp = 0, ans = 0;
        int flag = 7;

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < 7; j++) {
                if (strArr[i] == C[j]) {
                    if (j % 2 == 0 && (flag == 7 || flag == j)) {
                        tmp += N[j];
                        flag = j;
                    } else {
                        if (flag > j) {
                            ans += (N[j] - tmp);
                            tmp = 0;
                            flag = 7;
                        } else {
                            ans += tmp;
                            tmp = N[j];
                            flag = j;
                        }
                    }
                    break;
                }
            }
        }
        ans += tmp;

        return ans;
    }
}
