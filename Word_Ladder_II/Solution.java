import java.util.Hashtable;
public class Solution {
    public void getPath(String start, String end,
            Hashtable<String, ArrayList<String>> pre,
            ArrayList<ArrayList<String>> ans, ArrayList<String> path) {
        path.add(start);
        if (start.equals(end)) {
            ArrayList<String> ret = (ArrayList<String>) path.clone();
            Collections.reverse(ret);
            ans.add(ret);
        } else {
            for (String Ele : pre.get(start)) {
                getPath(Ele, end, pre, ans, path);
            }
        }
        path.remove(path.size() - 1);
    }
    public ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
        Queue<String> que = new ArrayDeque<String>();
        Set<String> visit = new HashSet<String>();
        Set<String> used = new HashSet<String>();
        Hashtable<String, ArrayList<String>> pre = new Hashtable<String, ArrayList<String>>();
        ArrayList<ArrayList<String>> ans = new ArrayList<ArrayList<String>>();
        Boolean found = false;

        int len = start.length(), level = 1;
        que.add(start);
        visit.add(start);
        
        while (!que.isEmpty()) {
            String strNp = que.poll();
            level --;

            char[] word = strNp.toCharArray();
            for (int i = 0; i < len; i++) {
                char saved = word[i];
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    if (ch == saved)
                        continue;
                    word[i] = ch;
                    String strTmp = new String(word);
                    if (strTmp.equals(end)) {
                        found = true;
                        ArrayList<String> _pre = pre.get(strTmp);
                        if (_pre == null) {
                            _pre = new ArrayList<String>();
                            pre.put(strTmp, _pre);
                        }
                        _pre.add(strNp);
                        break;
                    }
                    if (dict.contains(strTmp) && !visit.contains(strTmp)) {
                        used.add(strTmp);
                        ArrayList<String> _pre = pre.get(strTmp);
                        if (_pre == null) {
                            _pre = new ArrayList<String>();
                            pre.put(strTmp, _pre);
                        }
                        _pre.add(strNp);
                    }
                }
                word[i] = saved;
            }
            
            if (level == 0) {
                if (found) break;
                level = used.size();
                visit.addAll(used);
                que.addAll(used);
                used = new HashSet<String>();
            }
        }
        if (found) {
            ArrayList<String> path = new ArrayList<String>();
            getPath(end, start, pre, ans, path);
        }
        return ans;
    }
}
