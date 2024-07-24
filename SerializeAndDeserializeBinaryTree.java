/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

import java.util.Queue;
import java.util.LinkedList;

public class Codec {

    public static StringBuilder sbr;
    public String splitNum = ",";
    public String leafNode = "n";

    public String serialize(TreeNode root) {
        this.sbr = new StringBuilder();
        serializeHelper(root);
        return sbr.toString();
    }

    public void serializeHelper(TreeNode root) {
        if (root == null) {
            this.sbr.append(this.leafNode).append(this.splitNum);
            return;
        }

        this.sbr.append(root.val).append(this.splitNum);
        serializeHelper(root.left);
        serializeHelper(root.right);
    }

    public TreeNode deserialize(String data) {
        System.out.println(sbr.toString());
        System.out.println();
        Queue<String> q = new LinkedList<>();
        q.addAll(Arrays.asList(data.split(this.splitNum)));
        return deserializeHelper(q);
    }

    public TreeNode deserializeHelper(Queue<String> queue) {
        String val = queue.poll();

        if (val.equals(this.leafNode)) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(val));
        root.left = deserializeHelper(queue);
        root.right = deserializeHelper(queue);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));