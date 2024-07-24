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

import java.util.HashMap;

class Solution {

    int currIndex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int len = preorder.length;
        HashMap<Integer, Integer> hashmap = new HashMap<>();
        // Hashmap stores the indices of the elements in the inorder arr
        // Key => number in array of inorder, Value => index in the inorder array
        if (preorder.length == 0) {
            return new TreeNode();
        }
        for (int i = 0; i < inorder.length; i++) {
            hashmap.put(inorder[i], i);
        }
        return recursiveHelper(preorder, hashmap, 0, len - 1);
    }

    private TreeNode recursiveHelper(int[] preorder, HashMap<Integer, Integer> hashmap, int start, int end) {
        // So how to construct your base case. Seems like the only way is to establish a size base condition, which is
        // having 2 int values start and end as a form of measuring the size of your subtree. When it is small enough
        // aka the subtree is empty, just return null because there's just no TreeNodes left to construct a Binary Tree
        // The index position of the element in inorder tells you the size of your subtree as well
        // Got stuck with how to establish the base case :/
        if (start > end) {
            return null;
        }
        // Gets the index position of the root in the inorder array.
        // All the elements to the left of the element is in the left subtree, everything else to the right
        // is in the right subtree
        int inOrderIdx = hashmap.get(preorder[this.currIndex]);
        TreeNode root = new TreeNode(preorder[this.currIndex]);
        this.currIndex++;

        root.left = recursiveHelper(preorder, hashmap, start, inOrderIdx - 1);
        root.right = recursiveHelper(preorder, hashmap, inOrderIdx + 1, end);
        return root;
    }
}