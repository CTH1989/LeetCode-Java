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
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode pre = head, np = head.next;
        ListNode _head = new ListNode(0);
        _head.next = head;
        while (np != null) {
            ListNode next = np.next;
            ListNode pp = _head;
            while (pp != pre) {
                if (pp.next.val > np.val)
                    break;
                pp = pp.next;
            }
            if (pp == _head) {
                np.next = _head.next;
                _head.next = np;
                pre.next = next;
                np = next;
            } else if (pp == pre) {
                pre = np;
                np = next;
            } else {
                np.next = pp.next;
                pp.next = np;
                pre.next = next;
                np = next;
            }
        }
        return _head.next;
    }
}
