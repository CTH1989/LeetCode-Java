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
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> ans = new ArrayList<Interval>();
        if (intervals.size() == 0) {
            ans.add(newInterval);
            return ans;
        }
        if (newInterval.end < intervals.get(0).start) {
            ans.add(newInterval);
            for (int i = 0; i < intervals.size(); i ++)
                ans.add(intervals.get(i));
            return ans;
        }
        if (newInterval.start > intervals.get(intervals.size() - 1).end) {
            intervals.add(newInterval);
            return intervals;
        }
        if (newInterval.start < intervals.get(0).start && newInterval.end > intervals.get(intervals.size() - 1).end) {
            ans.add(newInterval);
            return ans;
        }
        
        int l = -1, r = -1, ll = -1, rr = -1;
        for (int i = 0; i < intervals.size(); i ++) {
            if (newInterval.start >= intervals.get(i).start && newInterval.start <= intervals.get(i).end) {
                l = i;
                ll = 0;
            }
            if (newInterval.end >= intervals.get(i).start && newInterval.end <= intervals.get(i).end) {
                r = i;
                rr = 0;
            }
            if (i != 0 && newInterval.start > intervals.get(i - 1).end && newInterval.start < intervals.get(i).start)
                l = i;
            if (i != 0 && newInterval.end > intervals.get(i - 1).end && newInterval.end < intervals.get(i).start)
                r = i - 1;
        }
        for (int i = 0; i < l; i ++)
            ans.add(intervals.get(i));
        int left, right;
        if (ll == 0)
            left = intervals.get(l).start;
        else
            left = newInterval.start;
        if (rr == 0)
            right = intervals.get(r).end;
        else
            right = newInterval.end;
        ans.add(new Interval(left, right));
        if (r != -1)
            for (int i = r + 1; i < intervals.size(); i ++)
                ans.add(intervals.get(i));
        return ans;
    }
}
