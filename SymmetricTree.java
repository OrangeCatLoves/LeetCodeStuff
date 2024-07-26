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
    public boolean isSymmetric(TreeNode root) {
        if (root.left == null && root.right == null) {
            return true;
        } else if (root.left != null && root.right == null) {
            return false;
        } else if (root.left == null && root.right != null) {
            return false;
        } else {
            return Helper(root.left, root.right);
        }
    }

    public boolean Helper(TreeNode leftRoot, TreeNode rightRoot) {
        if (leftRoot.left == null && leftRoot.right == null && rightRoot.left == null && rightRoot.right == null && leftRoot.val == rightRoot.val) {
            return true;
        } else if (leftRoot.left != null && leftRoot.right == null && rightRoot.left == null && rightRoot.right != null && leftRoot.val == rightRoot.val) {
            return Helper(leftRoot.left, rightRoot.right);
        } else if (leftRoot.left == null && leftRoot.right != null && rightRoot.left != null && rightRoot.right == null && leftRoot.val == rightRoot.val) {
            return Helper(leftRoot.right, rightRoot.left);
        } else if (leftRoot.left != null && leftRoot.right != null && rightRoot.left != null && rightRoot.right != null && leftRoot.val == rightRoot.val) {
            return Helper(leftRoot.left, rightRoot.right) && Helper(leftRoot.right, rightRoot.left);
        } else {
            return false;
        }
    }
}