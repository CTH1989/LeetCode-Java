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
    public ListNode swapPairs(ListNode head) {
        ListNode np = new ListNode(0), n1, n2;
        ListNode ans = np;
        np.next = head;
        while (np.next != null) {
            n1 = np.next;
            if (np.next.next == null) break;
            n2 = np.next.next;
            n1.next = n2.next;
            n2.next = n1;
            np.next = n2;
            np = n1;
        }
        
        return ans.next;
    }
}
