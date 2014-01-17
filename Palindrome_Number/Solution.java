public class Solution {
    public int y;
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        y = x;
        
        return isPalindromeRe(x);
    }
    
    public boolean isPalindromeRe(int x) {
        if (x == 0) return true;
        
        if (isPalindromeRe(x / 10) && (x % 10 == y % 10)) {
            y = y / 10;
            return true;
        } else {
            return false;
        }
    }
}
