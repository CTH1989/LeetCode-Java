public class Solution {
    public String intToRoman(int num) {
        // http://projecteuler.net/about=roman_numerals
        int N[] = {1000, 500, 100, 50, 10, 5, 1};
        char C[] = {'M', 'D', 'C', 'L', 'X', 'V', 'I'};
        int np = 0;
        StringBuffer ans = new StringBuffer();
        // 4 and 9
        while (num != 0) {
            if (np % 2 ==0 && num / N[np] == 4) {
                ans.append(C[np]);
                ans.append(C[np - 1]);
                num -= 4 * N[np];
            } else if (num >= N[np]) {
                ans.append(C[np]);
                num -= N[np];
            } else if (np % 2 == 0 && num / N[np + 2] == 9) {
                ans.append(C[np + 2]);
                ans.append(C[np]);
                num -= N[np + 2] * 9;
            } else np ++;
        }
        
        return ans.toString();
    }
}
