import java.util.Hashtable;
public class Solution {
    public ArrayList<Integer> findSubstring(String S, String[] L) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        Hashtable<Integer, Integer> ret = new Hashtable<Integer, Integer>();
        if (S == null || S.length() == 0) return ans;
        if (L.length == 0) return ans;
        if (L.length > S.length()) return ans;
        
        Hashtable<String, Integer> strNeed = new Hashtable<String, Integer>();
        ArrayList<ArrayList<String>> strLists = new ArrayList<ArrayList<String>>();
        char[] strArr = S.toCharArray();
        int wordLen = L[0].length(), len = strArr.length;
        
        
        for (int i = 0; i < L.length; i ++) {
            if (strNeed.containsKey(L[i])) {
                int tmp = strNeed.get(L[i]);
                strNeed.put(L[i], ++ tmp);
            } else
                strNeed.put(L[i], 1);
        }
        
        for (int i = 0; i <= len - wordLen * L.length; i ++) {
            ArrayList<String> _strList = new ArrayList<String>();
            if (!strNeed.containsKey(S.substring(i, i + wordLen))) {
                strLists.add(_strList);
                continue;
            }
            if (ret.containsKey(i)) {
                strLists.add(_strList);
                continue;
            }
            for (int j = i; j <= len - wordLen; j += wordLen) {
                ret.put(j, 1);
                String strTmp = S.substring(j, j + wordLen);
                _strList.add(strTmp);
            }
            strLists.add(_strList);
        }
        
        for (int i = 0; i <= len - wordLen * L.length; i ++) {
            ArrayList<String> strList = strLists.get(i);
            if (strList.size() == 0) continue;
            if (strNeed.containsKey(strList.get(0))) {
                Hashtable<String, Integer> strCount = new Hashtable<String, Integer>();
                int pp = 0, np = 0, count = 0;
                while (np < strList.size()) {
                    String strTmp = strList.get(np);
                    if (strNeed.containsKey(strTmp)) {
                        if (strCount.containsKey(strTmp)) {
                            int strCountNum = strCount.get(strTmp);
                            strCountNum ++;
                            if (strCountNum <= strNeed.get(strTmp)) {
                                strCount.put(strTmp, strCountNum);
                                count ++;
                                np ++;
                            } else {
                                while (pp < np) {
                                    String _strTmp = strList.get(pp);
                                    if (_strTmp.equals(strTmp)) {
                                        pp ++;
                                        np ++;
                                        break;
                                    }
                                    count --;
                                    int countNum = strCount.get(_strTmp);
                                    strCount.put(_strTmp, countNum - 1);
                                    pp ++;
                                }
                            }
                        } else {
                            count ++;
                            strCount.put(strTmp, 1);
                            np ++;
                        }
                    } else {
                        strCount = new Hashtable<String, Integer>();
                        count = 0;
                        np ++;
                        pp = np;
                    }
                    if (count == L.length) {
                        ans.add(i + pp * wordLen);
                        String _strTmp = strList.get(pp);
                        int countNum = strCount.get(strList.get(pp));
                        strCount.put(_strTmp, countNum - 1);
                        pp ++;
                        count --;
                    }
                }
            }
        }
        
        return ans;
    }
}
