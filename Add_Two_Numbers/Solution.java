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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode a = l1;
        ListNode b = l2;
        ListNode head;
        ListNode np = new ListNode(0);
        head = np;
        while (a != null && b != null) {
            int tmp = a.val + b.val + carry;
            carry = tmp / 10;
            np.next = new ListNode(tmp % 10);
            np = np.next;
            a = a.next;
            b = b.next;
        }

        while (a != null) {
            int tmp = a.val + carry;
            carry = tmp / 10;
            np.next = new ListNode(tmp % 10);
            np = np.next;
            a = a.next;
        }

        while (b != null) {
            int tmp = b.val + carry;
            carry = tmp / 10;
            np.next = new ListNode(tmp % 10);
            np = np.next;
            b = b.next;
        }
        
        if (carry == 1) {
            np.next = new ListNode(carry);
        }
        
        return head.next;
    }
}
