public class Solution {
    public String simplifyPath(String path) {
        path += "/";
        ArrayList<String> list = new ArrayList<String>();
        int len = path.length();
        char[] arr = path.toCharArray();
        int np = -1;
        for (int i = 0; i < len; i ++) {
            if (arr[i] == '/') {
                if (np == -1) {
                    np = i;
                } else {
                    String strTmp = path.substring(np + 1, i);
                    np = i;
                    if (strTmp.equals("") || strTmp.equals("."))
                        continue;
                    else if (strTmp.equals("..")) {
                        if (!list.isEmpty())
                            list.remove(list.size() - 1);
                    } else {
                        list.add(strTmp);
                    }
                }
            }
        }
        String ans = "/";
        for (int i = 0; i < list.size(); i ++) {
            ans += list.get(i);
            if (i != list.size() - 1)
                ans += "/";
        }
        return ans;
    }
}
