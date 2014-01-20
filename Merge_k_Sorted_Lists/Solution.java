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
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        if (lists.size() == 0) return null;
        PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(
                lists.size(), new Comparator<ListNode>() {
                    @Override
                    public int compare(ListNode n1, ListNode n2) {
                        return (n1.val - n2.val);
                    }
                });
        for (ListNode Ele : lists) {
            if (Ele != null) heap.add(Ele);
        }
        
        ListNode head = null, np = null;
        while (!heap.isEmpty()) {
            ListNode tmp = heap.poll();
            if (head == null) {
                head = tmp;
                np = tmp;
            } else {
                np.next = tmp;
                np = np.next;
            }
            if (tmp.next != null) heap.add(tmp.next);
        }
        
        return head;
    }
    // list.add(null) -> size + 1
}
