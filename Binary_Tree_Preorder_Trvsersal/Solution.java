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
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        ArrayList<Integer> ans = new ArrayList<Integer>();
        if (root == null)
            return ans;
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode np = stack.pop();
            ans.add(np.val);
            if (np.right != null)
                stack.add(np.right);
            if (np.left != null)
                stack.add(np.left);
        }
        return ans;
    }
}
