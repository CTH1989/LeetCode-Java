public class Solution {
    public int ladderLength(String start, String end, HashSet<String> dict) {
        Queue<String> que = new ArrayDeque<String>();
        Queue<Integer> stp = new ArrayDeque<Integer>();
        Set<String> visit = new HashSet<String>();
        
        int len = start.length();
        que.add(start);
        stp.add(0);
        
        while (!que.isEmpty()) {
            String strNp = que.poll();
            int stpNp = stp.poll();
            
            char[] word = strNp.toCharArray();
            for (int i = 0; i < len; i ++) {
                char saved = word[i];
                for (char ch = 'a'; ch <= 'z'; ch ++) {
                    word[i] = ch;
                    String strTmp = new String(word);
                    if (strTmp.equals(end)) return stpNp + 2;
                    if (dict.contains(strTmp) && !visit.contains(strTmp)) {
                        que.add(strTmp);
                        stp.add(stpNp + 1);
                        visit.add(strTmp);
                    }
                }
                word[i] = saved;
            }
        }
        return 0;
    }
}
