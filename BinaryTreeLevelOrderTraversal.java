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

import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> currFrontier = new LinkedList<>();
        Queue<TreeNode> nextFrontier = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        currFrontier.add(root);
        boolean terminate = true;
        while (terminate) {
            List<Integer> currBreadth = new ArrayList<>();
            for (TreeNode node: currFrontier) {
                currBreadth.add(node.val);
            }
            result.add(currBreadth);
            for (TreeNode dequeuedNode: currFrontier) {
                if (dequeuedNode.left != null && dequeuedNode.right == null) {
                    nextFrontier.add(dequeuedNode.left);
                } else if (dequeuedNode.left == null && dequeuedNode.right != null) {
                    nextFrontier.add(dequeuedNode.right);
                } else if (dequeuedNode.left != null && dequeuedNode.right != null) {
                    nextFrontier.add(dequeuedNode.left);
                    nextFrontier.add(dequeuedNode.right);
                }
            }
            //TreeNode dequeuedNode = currFrontier.poll();
            if (nextFrontier.isEmpty()) {
                terminate = false;
            } else {
                currFrontier = nextFrontier;
                nextFrontier = new LinkedList<>();
            }
        }
        return result;
    }
}