/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null) {
            if (p == null && q == null) {
                return true;
            } else {
                return false;
            }
        } else if (p.val == q.val && p.left == null && q.left == null && p.right == null && q.right == null) {
            return true;
        } else if (p.val == q.val && p.left != null && q.left != null && p.right == null && q.right == null) {
            return isSameTree(p.left, q.left);
        } else if (p.val == q.val && p.left == null && q.left == null && p.right != null && q.right != null) {
            return isSameTree(p.right, q.right);
        } else if (p.val == q.val && p.left != null && q.left != null && p.right != null && q.right != null) {
            return isSameTree(p.right, q.right) && isSameTree(p.left, q.left);
        } else {
            return false;
        }
    }
}