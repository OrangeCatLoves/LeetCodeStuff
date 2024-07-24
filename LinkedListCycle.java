/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {

    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        if (head.next == null) {
            return false;
        }
        ListNode slowPointer = head;
        ListNode fastPointer = head;
        while (true) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next;
            if (fastPointer == null) {
                return false;
            }
            fastPointer = fastPointer.next;
            if (fastPointer == null) {
                return false;
            }
            if (fastPointer == slowPointer) {
                return true;
            }
        }
    }
}