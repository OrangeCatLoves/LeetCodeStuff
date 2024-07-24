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


import java.util.ArrayList;
class Solution {

    public boolean isValidBST(TreeNode root) {
        // Perform an in-order traversal and record them in a list. Check if they're strictly
        // Increasing or not
        ArrayList<Integer> arrList = new ArrayList<>();
        inOrderTraversal(root, arrList);
        int len = arrList.size();
        for (int i = 0; i < len - 1; i++) {
            if (arrList.get(i) >= arrList.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    public void inOrderTraversal(TreeNode node, ArrayList list) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            inOrderTraversal(node.left, list);
        }
        list.add(node.val);
        if (node.right != null) {
            inOrderTraversal(node.right, list);
        }
        return;
    }
}