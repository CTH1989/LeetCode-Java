public class Solution {
    public ArrayList<String> fullJustify(String[] words, int L) {
        ArrayList<String> ans = new ArrayList<String>();
        for (int i = 0; i < words.length; ) {
            int len = L - words[i].length(), j = i + 1;
            while (j < words.length && len - (1 + words[j].length()) >= 0) {
                len -= (1 + words[j].length());
                j ++;
            }
            j --;
            String ret = "";
            int total = len + (j - i);
            if (j == i) {
                ret += words[j];
                for (int n = 0; n < total; n ++) ret += " ";
            } else {
                if (j == words.length - 1) {
                    for (int m = i; m <= j; m ++) {
                        ret += words[m];
                        if (m != j) {
                            ret += " ";
                            total --;
                        }
                    }
                    for (int n = 0; n < total; n ++)
                        ret += " ";
                } else {
                    int numSpace = total / (j - i);
                    int addSpace = total % (j - i);
                    for (int m = i; m <= j; m ++) {
                        ret += words[m];
                        if (m != j) {
                            for (int n = 0; n < numSpace; n ++)
                                ret += " ";
                            if (addSpace != 0) {
                                ret += " ";
                                addSpace --;
                            }
                        }
                    }
                }
            }
            ans.add(ret);
            i = j + 1;
        }
        return ans;
    }
}
