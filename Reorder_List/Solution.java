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
    public ListNode _head;

    public ListNode reverseList(ListNode np) {
        if (np.next == null) {
            _head = np;
            return np;
        }
        ListNode tp = reverseList(np.next);
        tp.next = np;
        return np;
    }

    public void reorderList(ListNode head) {
        if (head == null)
            return;
        int num = 1, count;
        ListNode tp = head;
        while (tp.next != null) {
            tp = tp.next;
            num++;
        }

        if (num < 3)
            return;
        ListNode list1 = head, list2;
        tp = head;
        count = 1;
        while (count < num / 2) {
            tp = tp.next;
            count++;
        }
        if (num % 2 == 1)
            tp = tp.next;

        list2 = tp.next;
        tp.next = null;

        tp = reverseList(list2);
        tp.next = null;
        list2 = _head;

        while (list2 != null) {
            ListNode np = list1, pp = list1.next, mp = list2.next;
            np.next = list2;
            list2.next = pp;
            list1 = pp;
            list2 = mp;
        }
    }
}
