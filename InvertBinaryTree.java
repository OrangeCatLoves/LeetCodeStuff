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

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        } else {
            invertHelper(root);
            return root;
        }
    }

    public void invertHelper(TreeNode root) {
        if (root.right == null && root.left == null) {
            return;
        } else if (root.right != null && root.left == null) {
            TreeNode temp = root.right;
            root.right = null;
            root.left = temp;
            invertHelper(root.left);
        } else if (root.right == null && root.left != null) {
            TreeNode temp = root.left;
            root.left = null;
            root.right = temp;
            invertHelper(root.right);
        } else if (root.right != null && root.left != null) {
            TreeNode temp = root.right;
            root.right = root.left;
            root.left = temp;
            invertHelper(root.right);
            invertHelper(root.left);
        }
    }
}