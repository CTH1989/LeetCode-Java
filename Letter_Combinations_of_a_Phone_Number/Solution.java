public class Solution {
    public ArrayList<String> letterCombinations(String digits) {
        ArrayList<String> ans = new ArrayList<String>();
        StringBuffer str;
        if (digits.length() == 0) {
            ans.add(new String(""));
            return ans;
        }
        int first = digits.charAt(0) - '0', len, head, tail;
        if (first <= 6) {
            head = 3 * (first - 2);
            tail = head + 2;
        } else if (first == 7) {
            head = 15;
            tail = 18;
        } else if (first == 8) {
            head = 19;
            tail = 21;
        } else {
            head = 22;
            tail = 25;
        }
        
        ArrayList<String> ret = letterCombinations(digits.substring(1));
        
        for (int i = head; i <= tail; i ++) {
            char ch = (char) ('a' + i);
            for (String Ele : ret) {
                str = new StringBuffer();
                str.append(ch);
                str.append(Ele);
                ans.add(str.toString());
            }
        }
        
        return ans;
    }
}
