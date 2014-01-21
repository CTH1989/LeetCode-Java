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
    public ListNode recursive(ListNode head, ListNode node, int k) {
        if (k == 1) {
            head.next = node;
            return node.next;
        }
        ListNode nt = node.next;
        ListNode ans = recursive(head, nt, k - 1);
        nt.next = node;
        return ans;
    }
    
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode ans, np, pp, nt;
        int i;
        ans = new ListNode(0);
        np = ans;
        np.next = head;
        while (np.next != null) {
            nt = pp = np.next;
            for (i = 0; i < k ; i ++) {
                if (pp == null) break;
                pp = pp.next;
            }
            if (i < k) break;
            nt.next = recursive(np, np.next, k);
            np = nt;
        }
        return ans.next;
    }
}
