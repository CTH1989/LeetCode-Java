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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode _head = new ListNode(0);
        _head.next = head;
        ListNode np = head, pp = head, pre = _head;
        while (np != null) {
            if (np.val != pp.val) {
                if (pp.next == np) {
                    pre = pp;
                    pp = np;
                } else {
                    pre.next = np;
                    pp = np;
                }
            }
            np = np.next;
        }
        if (pp.next != null)
            pre.next = null;
        return _head.next;
    }
}
