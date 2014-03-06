/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode merge(ListNode list1, ListNode list2) {
        ListNode head = null, np = null;
        while (list2 != null && list1 != null) {
            if (list1.val < list2.val) {
                if (head == null) {
                    head = list1;
                    np = head;
                } else {
                    np.next = list1;
                    np = np.next;
                }
                list1 = list1.next;
            } else {
                if (head == null) {
                    head = list2;
                    np = head;
                } else {
                    np.next = list2;
                    np = np.next;
                }
                list2 = list2.next;
            }
        }
        if (list1 == null) {
            np.next = list2;
        } else {
            np.next = list1;
        }
        return head;
    }
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode _head = null, np = head, _np = null;
        while (np.next != null) {
            if (_head == null) {
                _head = new ListNode(np.next.val);
                _np = _head;
            } else {
                _np.next = new ListNode(np.next.val);
                _np = _np.next;
            }
            np.next = np.next.next;
            np = np.next;
            if (np == null) break;
        }
        ListNode ans = merge(sortList(head), sortList(_head));
        return ans;
    }
}
