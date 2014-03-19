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
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        Stack<TreeNode> stack = new Stack<TreeNode>();
        ArrayList<Integer> ans = new ArrayList<Integer>();
        if (root == null)
            return ans;
        stack.add(root);
        TreeNode pre = null;
        while (!stack.isEmpty()) {
            TreeNode np = stack.peek();
            if ((np.left == null && np.right == null) || (pre!= null && (pre == np.right || np.right == null && pre == np.left))) {
                np = stack.pop();
                pre = np;
                ans.add(np.val);
            } else {
                if (np.right != null)
                    stack.add(np.right);
                if (np.left != null)
                    stack.add(np.left);
            }
        }
        return ans;
    }
}
