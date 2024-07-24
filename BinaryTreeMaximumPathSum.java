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

    int finalResult = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        pathSum(root);
        return this.finalResult;
    }

    public int pathSum(TreeNode node) {
        if (node == null) {
            return 0;
        }
        // Why compare with zero here ?
        int leftMax = Math.max(pathSum(node.left), 0);
        int rightMax = Math.max(pathSum(node.right), 0);
        this.finalResult = Math.max(node.val + leftMax + rightMax, this.finalResult);
        /*Math.max(node.val + left,
        Math.max(node.val + right,
        Math.max(left, right)))));*/

        return Math.max(leftMax, rightMax) + node.val;
    }
}