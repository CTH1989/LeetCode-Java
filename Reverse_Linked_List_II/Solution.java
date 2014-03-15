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
    public ListNode nTail, nHead;
    public ListNode reverse(int n, ListNode np) {
        if (n == 0) {
            nHead = np;
            nTail.next = np.next;
            return np;
        }
        ListNode ret = reverse(n - 1, np.next);
        ret.next = np;
        return np;
    }
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null)
            return head;
        ListNode _head = new ListNode(0);
        _head.next = head;
        ListNode pre = _head, np = head;
        int count = 1;
        while (count < m) {
            pre = pre.next;
            np = np.next;
            count++;
        }
        nTail = np;
        reverse(n - m, np);
        pre.next = nHead;
        return _head.next;
    }
}
