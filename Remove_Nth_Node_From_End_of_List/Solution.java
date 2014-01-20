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
    public int remove(ListNode node, int n) {
        if (node.next == null)
            return 1;

        int ret = remove(node.next, n);
        if (ret == n) {
            node.next = node.next.next;
        }

        return ret + 1;
    }
    
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode np = new ListNode(0);
        np.next = head;
        remove(np, n);
        return np.next;
    }
}
