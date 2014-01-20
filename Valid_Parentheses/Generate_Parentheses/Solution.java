public class Solution {
    public ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> ans = new ArrayList<String>();
        HashMap<String, Boolean> map = new HashMap<String, Boolean>();
        if (n == 1) {
            ans.add(new String("()"));
            return ans;
        }

        ArrayList<String> ret = generateParenthesis(n - 1);

        for (String Ele : ret) {
            StringBuilder str = new StringBuilder();
            str.append("(").append(Ele).append(")");
            if (!map.containsKey(str.toString())) {
                ans.add(str.toString());
                map.put(str.toString(), true);
            }
        }

        for (int i = 1; i <= n / 2; i++) {
            ArrayList<String> ret1;
            ArrayList<String> ret2;
            if (i == 1) {
                ret1 = generateParenthesis(1);
                ret2 = ret;
            } else {
                ret1 = generateParenthesis(i);
                ret2 = generateParenthesis(n - i);
            }
            
            for (String Ele : ret1) {
                for (String ele : ret2) {
                    StringBuilder str1 = new StringBuilder();
                    StringBuilder str2 = new StringBuilder();
                    str1.append(Ele).append(ele);
                    if (!map.containsKey(str1.toString())) {
                        ans.add(str1.toString());
                        map.put(str1.toString(), true);
                    }
                    str2.append(ele).append(Ele);
                    if (!map.containsKey(str2.toString())) {
                        ans.add(str2.toString());
                        map.put(str2.toString(), true);
                    }
                }
            }
        }

        Collections.sort(ans);
        return ans;
    }
}
