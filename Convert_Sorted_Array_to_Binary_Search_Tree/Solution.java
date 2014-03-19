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
    public TreeNode sortedArrayToBST(int[] num) {
        int len = num.length;
        if (len == 0)
            return null;
        int mid = len / 2;
        TreeNode np = new TreeNode(num[mid]);
        int len1 = mid - 0;
        int len2 = len - mid - 1;
        int[] num1 = new int[len1];
        int[] num2 = new int[len2];
        for (int i = 0; i < mid; i++)
            num1[i] = num[i];
        for (int i = mid + 1; i < len; i++)
            num2[i - mid - 1] = num[i];
        np.left = sortedArrayToBST(num1);
        np.right = sortedArrayToBST(num2);
        return np;
    }
}
