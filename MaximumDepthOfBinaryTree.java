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

    int longestDepth = 0;

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        maxDepthHelper(root, 1);
        return this.longestDepth;
    }

    public void maxDepthHelper(TreeNode node, int currDepth) {
        int depth = currDepth + 1;
        if (node.right == null && node.left == null) {
            if (currDepth > this.longestDepth) {
                this.longestDepth = currDepth;
            }
            return;
        } else if (node.right != null && node.left == null) {
            if (currDepth > this.longestDepth) {
                this.longestDepth = currDepth;
            }
            maxDepthHelper(node.right, depth);
        } else if (node.right == null && node.left != null) {
            if (currDepth > this.longestDepth) {
                this.longestDepth = currDepth;
            }
            maxDepthHelper(node.left, depth);
        } else if (node.right != null && node.left != null) {
            if (currDepth > this.longestDepth) {
                this.longestDepth = currDepth;
            }
            maxDepthHelper(node.left, depth);
            maxDepthHelper(node.right, depth);
        } else {
            return;
        }
    }
}