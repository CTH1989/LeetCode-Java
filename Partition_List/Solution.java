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
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null)
            return head;
        ListNode list1 = new ListNode(0), list2 = new ListNode(0);
        list1.next = head;
        ListNode pre = list1, np = head, pp = list2;
        while (np != null) {
            if (np.val >= x) {
                pp.next = new ListNode(np.val);
                pp = pp.next;
                pre.next = np.next;
            } else
                pre = np;
            np = np.next;
        }
        pre.next = list2.next;
        return list1.next;
    }
}
