import java.util.HashMap;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        HashMap<Integer, ListNode> hashmap = new HashMap<>();
        ListNode result = head;
        ListNode traversingPointer = head;
        int count = 0; // At the end should represent the total number of nodes in the list
        if (head.next == null && n == 1) {
            return null;
        }
        while (traversingPointer != null) {
            count++;
            System.out.println(count);
            hashmap.put(count, traversingPointer);
            traversingPointer = traversingPointer.next;
        }
        if (count == 2) {
            if (n == 1) {
                head.next = null;
                return head;
            } else if (n == 2) {
                ListNode node = head.next;
                head.next = null;
                return node;
            }
        }
        System.out.println(count);
        if (count - n > 0 && n > 1) {
            System.out.println("Case 1");
            ListNode nodeToBeRemoved = hashmap.get(count - n + 1);
            ListNode previousNode = hashmap.get(count - n);
            ListNode afterNode = hashmap.get(count - n + 2);
            previousNode.next = afterNode;
        } else if (count - n > 0) { // Last Node getting removed
            System.out.println("Case 2");
            ListNode previousNode = hashmap.get(count - n);
            previousNode.next = null;
        } else if (n > 1) { // First node getting removed
            System.out.println("Case 3");
            ListNode nodeToBeRemoved = hashmap.get(count - n + 1);
            result = nodeToBeRemoved.next;
            nodeToBeRemoved.next = null;
        }
        return result;
    }
}