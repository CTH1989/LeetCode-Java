public class Solution {
    public String minWindow(String S, String T) {
        if (S.length() == 0 || T.length() == 0)
            return "";
        char[] sou = S.toCharArray();
        char[] tar = T.toCharArray();

        int[] charNeed = new int[256];
        int[] charFound = new int[256];

        
        for (int i = 0; i < tar.length; i++) {
            charNeed[tar[i]]++;
        }
        
        for (int i = 0; i < 256; i ++) {
            charFound[i] = 0;
        }

        int pp = 0, np = 0, minLength = Integer.MAX_VALUE, count = 0;
        int ansPp = -1, ansNp = -1;
        for (; np < sou.length; np++) {
            if (charNeed[sou[np]] == 0)
                continue;
            charFound[sou[np]]++;
            if (charFound[sou[np]] <= charNeed[sou[np]])
                count++;
            if (count == tar.length) {
                while (charNeed[sou[pp]] == 0
                        || charFound[sou[pp]] > charNeed[sou[pp]]) {
                    if (charFound[sou[pp]] > charNeed[sou[pp]])
                        charFound[sou[pp]]--;
                    pp++;
                }
                if (np - pp + 1 < minLength) {
                    ansPp = pp;
                    ansNp = np;
                    minLength = np - pp + 1;
                }
            }
        }
        if (ansPp == -1)
            return "";
        else
            return S.substring(ansPp, ansNp + 1);
    }
}
