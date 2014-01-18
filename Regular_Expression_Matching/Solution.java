public class Solution {
    public boolean isMatch(String s, String p) {
        // http://stackoverflow.com/questions/12469437/regular-expression-matching-support-for-and
        if (p.length() == 0) {
            if (s.length() == 0)
                return true;
            else
                return false;
        }

        if (s.length() == 0) {
            if (p.length() > 1 && p.charAt(1) == '*') {
                return isMatch(s, p.substring(2));
            } else return false;
        } else {
            if (p.length() > 1 && p.charAt(1) == '*') {
                if (p.charAt(0) != s.charAt(0) && p.charAt(0) != '.') {
                    return isMatch(s, p.substring(2));
                } else {
                    // no need to check isMatch(s.substring(1), p.substring(2)) 
                    return isMatch(s, p.substring(2)) || isMatch(s.substring(1), p); 
                }
            } else {
                if (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.') {
                    return isMatch(s.substring(1), p.substring(1));
                } else {
                    return false;
                }
            }
        }
    }
    /*
        isMatch("aa", "a")
        isMatch("aa", "aa")
        isMatch("aaa", "aa")
        isMatch("aa", "a*")
        isMatch("aa", ".*")
        isMatch("ab", ".*")
        isMatch("aab", "c*a*b")
        isMatch("aaa", "a*a")
        isMatch("a", "ab*")
        isMatch("aaaaaaaaaaaaab", "a*a*a*a*a*a*a*a*a*a*c")
        isMatch("aaa", "a.a")
        isMatch("aaa", "ab*a*c*a")
        isMatch("", ".")
    */
}
