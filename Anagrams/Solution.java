import java.util.Hashtable;
public class Solution {
    public ArrayList<String> anagrams(String[] strs) {
        ArrayList<String> ans = new ArrayList<String>();
        if (strs.length < 2)
            return ans;
        Hashtable<String, Integer> hash = new Hashtable<String, Integer>();
        for (int i = 0; i < strs.length; i++) {
            String strNp = strs[i];
            char[] arr = strNp.toCharArray();
            Arrays.sort(arr);
            String strPp = String.valueOf(arr);
            if (hash.containsKey(strPp)) {
                ans.add(strNp);
                int np = hash.get(strPp);
                if (np != -1) {
                    ans.add(strs[np]);
                    hash.put(strPp, -1);
                }
            } else
                hash.put(strPp, i);
        }
        return ans;
    }
}
