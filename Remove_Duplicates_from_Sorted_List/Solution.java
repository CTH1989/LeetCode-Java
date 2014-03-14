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
        ListNode np = head, pp = head;
        while (np != null) {
            if (np.val != pp.val) {
                pp.next = np;
                pp = np;
            }
            np = np.next;
        }
        pp.next = null;
        return head;
    }
}
