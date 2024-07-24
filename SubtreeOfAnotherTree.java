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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        } else if (check(root, subRoot)) {
            return true;
        } else {
            if (root.left != null && root.right != null) {
                return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
            } else if (root.left == null && root.right != null) {
                return isSubtree(root.right, subRoot);
            } else if (root.left != null && root.right == null) {
                return isSubtree(root.left, subRoot);
            } else {
                return false;
            }
        }
    }

    public boolean check(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        } else if (root.val != subRoot.val) {
            return false;
        } else if (root.left == null && subRoot.left == null && root.right == null && subRoot.right == null && root.val == subRoot.val) {
            return true;
        } else if (root.left != null && subRoot.left != null && root.right == null && subRoot.right == null && root.val == subRoot.val) {
            return check(root.left, subRoot.left);
        } else if (root.left == null && subRoot.left == null && root.right != null && subRoot.right != null && root.val == subRoot.val) {
            return check(root.right, subRoot.right);
        } else if (root.left != null && subRoot.left != null && root.right != null && subRoot.right != null && root.val == subRoot.val) {
            return check(root.left, subRoot.left) && check(root.right, subRoot.right);
        } else {
            return false;
        }
    }
}