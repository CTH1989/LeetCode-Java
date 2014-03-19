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
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        if (root == null)
            return ans;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode pRoot = root;
        while (pRoot != null || !stack.isEmpty()) {
            if (pRoot != null) {
                stack.add(pRoot);
                pRoot = pRoot.left;
            } else {
                pRoot = stack.pop();
                ans.add(pRoot.val);
                pRoot = pRoot.right;
            }
        }
        return ans;
    }
}
