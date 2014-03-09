/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        if (intervals.size() == 0 || intervals.size() == 1)
            return intervals;
        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval a, Interval b) {
                if (a.start == b.start)
                    return a.end - b.end;
                else
                    return a.start - b.start;
            }
        });
        Interval np = intervals.get(0), pp = intervals.get(0);
        ArrayList<Interval> ans = new ArrayList<Interval>();
        for (int i = 1; i < intervals.size(); i ++) {
            if (intervals.get(i).start <= pp.end) {
                if (intervals.get(i).end > pp.end)
                    pp = intervals.get(i);
            } else {
                ans.add(new Interval(np.start, pp.end));
                np = intervals.get(i);
                pp = intervals.get(i);
            }
        }
        ans.add(new Interval(np.start, pp.end));
        return ans;
    }
}
