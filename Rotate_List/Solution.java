/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode ans, tail, _tail;
    public int rec(ListNode np, int target) {
        if (np == null)
            return 0;
        int ret = rec(np.next, target) + 1;
        if (ret == 1) {
            tail = np;
        }
        if (ret == target) {
            ans = np;
        }
        if (ret == target + 1) {
            _tail = np;
        }
        return ret;
    }
    public ListNode rotateRight(ListNode head, int n) {
        if (head == null)
            return null;
        ListNode np = head;
        int num = 0;
        while (np != null) {
            np = np.next;
            num ++;
        }
        n %= num;
        if (n == 0)
            return head;
        ans = null;
        tail = null;
        _tail = null;
        rec(head, n);
        tail.next = head;
        _tail.next = null;
        return ans;
    }
}
