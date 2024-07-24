/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

import java.util.ArrayList;
import java.util.List;

class Solution {

    boolean foundP;
    boolean foundQ;
    String directionsToP;
    String directionsToQ;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return new TreeNode();
        }

        List<TreeNode> setP = new ArrayList<>();
        List<TreeNode> setQ = new ArrayList<>();
        getDirections(root, p, q, ""); // Populate directionsToP and directionsToQ
        populateSets(root, setP, setQ);
        System.out.println(this.directionsToP);
        System.out.println(this.directionsToQ);
        System.out.println("Set P size is: " + setP.size());
        System.out.println("Set Q size is: " + setQ.size());
        int latestP = setP.size();
        int latestQ = setQ.size();

        // There's something wrong here !
        for (int i = setP.size() - 1; i >= 0; i--) {
            for (int j = setQ.size() - 1; j >= 0; j--) {
                if (setP.get(i).val == setQ.get(j).val && i < latestP && j < latestQ) {
                    latestP = i;
                    latestQ = j;
                    return setP.get(latestP);
                }
            }
        }
        System.out.println("Index of P in set P is: " + latestP);
        System.out.println("Index of Q in set Q is: " + latestQ);
        return setP.get(latestP);
    }

    // q=> 6 2 4
    // p=> 6 2
    public void getDirections(TreeNode root, TreeNode p, TreeNode q, String sequence) {
        if (this.foundP && this.foundQ) {
            return;
        }
        if (root.val == p.val) {
            this.foundP = true;
            this.directionsToP = sequence;
        }
        if (root.val == q.val) {
            this.foundQ = true;
            this.directionsToQ = sequence;
        }

        if (root.left != null && root.right != null) {
            StringBuilder sb1 = new StringBuilder(sequence);
            StringBuilder sb2 = new StringBuilder(sequence);
            getDirections(root.left, p, q, sb1 + "L");
            getDirections(root.right, p, q, sb2 + "R");
        } else if (root.left == null && root.right != null) {
            StringBuilder sb1 = new StringBuilder(sequence);
            getDirections(root.right, p, q, sb1 + "R");
        } else if (root.left != null && root.right == null) {
            StringBuilder sb1 = new StringBuilder(sequence);
            getDirections(root.left, p, q, sb1 + "L");
        }
    }

    public void populateSets(TreeNode root, List<TreeNode> setP, List<TreeNode> setQ) {
        TreeNode node = root;
        setP.add(node);
        setQ.add(node);
        for (int i = 0; i < this.directionsToP.length(); i++) {
            if (this.directionsToP.charAt(i) == 'R') {
                node = node.right;
                setP.add(node);
            } else if (this.directionsToP.charAt(i) == 'L') {
                node = node.left;
                setP.add(node);
            }
        }
        node = root;
        for (int i = 0; i < this.directionsToQ.length(); i++) {
            if (this.directionsToQ.charAt(i) == 'R') {
                node = node.right;
                setQ.add(node);
            } else if (this.directionsToQ.charAt(i) == 'L') {
                node = node.left;
                setQ.add(node);
            }
        }
    }
}