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

    public int kthSmallest(TreeNode root, int k) {
        List<TreeNode> seq = new ArrayList<>();
        inOrderTraversal(root, seq);
        return seq.get(k - 1).val;
    }

    public void inOrderTraversal(TreeNode root, List<TreeNode> list) {
        if (root == null) {
            return;
        }

        if (root.left != null) {
            inOrderTraversal(root.left, list);
        }
        list.add(root);
        if (root.right != null) {
            inOrderTraversal(root.right, list);
        }

    }
}