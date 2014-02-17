public class Solution {
    public boolean isMatch(String s, String p) {
        // http://yucoding.blogspot.com/2013/02/leetcode-question-123-wildcard-matching.html
        String S = s + "0";
        String P = p + "0";
        int sp = 0, pp = 0;
        int sta = -1, ss = 0;
        while (S.charAt(sp) != '0') {
            if (P.charAt(pp) == '?' || P.charAt(pp) == S.charAt(sp)) {
                sp ++;
                pp ++;
            } else if (P.charAt(pp) == '*') {
                sta = pp ++;
                ss = sp;
            } else if (sta != -1) {
                pp = sta + 1;
                sp = ++ ss;
            } else return false;
        }
        while (P.charAt(pp) == '*') {
            pp ++;
            if (P.charAt(pp) == '0') break;
        }
        if (P.charAt(pp) == '0') return true;
        else return false;
    }
}
