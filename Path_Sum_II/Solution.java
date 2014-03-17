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
    public void dfs(TreeNode node, int sum, ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> path) {
        if (node.left == null && node.right == null) {
            if (sum - node.val == 0) {
                ArrayList<Integer> ret = (ArrayList<Integer>) path.clone();
                ret.add(node.val);
                ans.add(ret);
            }
            return ;
        }
        if (node.right != null) {
            path.add(node.val);
            dfs(node.right, sum - node.val, ans, path);
            path.remove(path.size() - 1);
        }
        if (node.left != null) {
            path.add(node.val);
            dfs(node.left, sum - node.val, ans, path);
            path.remove(path.size() - 1);
        }
    }
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        if (root == null)
            return ans;
        ArrayList<Integer> path = new ArrayList<Integer>();
        dfs(root, sum, ans, path);
        return ans;
    }
}
