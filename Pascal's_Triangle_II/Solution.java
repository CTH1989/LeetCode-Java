public class Solution {
    public int gcd(int a, int b) {
        while (b > 0) {
            int c = a % b;
            a = b;
            b = c;
        }
        return a;
    }
    public ArrayList<Integer> getRow(int rowIndex) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        if (rowIndex == 0) {
            ans.add(1);
            return ans;
        }
        ans.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            int mul1 = ans.get(i - 1);
            int mul2 = (rowIndex - i + 1);
            int div = i;
            int g1 = gcd(mul1, div);
            int g2 = gcd(mul2, div);
            int mul;
            if (g1 > g2) {
                mul = mul1 / g1 * mul2;
                div /= g1;
            } else {
                mul = mul2 / g2 * mul1;
                div /= g2;
            }
            ans.add(mul / div);
        }
        return ans;
    }
}
