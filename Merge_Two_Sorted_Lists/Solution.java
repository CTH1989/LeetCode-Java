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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0), np = head;
        head.next = l1;
        while (np.next != null && l2!= null) {
            if (np.next.val > l2.val) {
                ListNode tmp = np.next;
                np.next = l2;
                l2 = l2.next;
                np.next.next = tmp;
                np = np.next;
            } else {
                np = np.next;
            }
        }
        if (l2 != null)
            np.next = l2;
        return head.next;
    }
}
