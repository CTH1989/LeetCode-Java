/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null)
            return null;
        ListNode np = head;
        int num = 0;
        while (np != null) {
            np = np.next;
            num++;
        }
        if (num == 1)
            return new TreeNode(head.val);
        if (num == 2) {
            TreeNode root = new TreeNode(head.val);
            root.right = new TreeNode(head.next.val);
            return root;
        }
        ListNode _head = new ListNode(0);
        _head.next = head;
        ListNode pre = _head;
        np = head;
        int len = num / 2;
        while (len != 0) {
            np = np.next;
            pre = pre.next;
            len--;
        }
        TreeNode root = new TreeNode(np.val);
        pre.next = null;
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(np.next);
        return root;
    }
}
