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
    public ListNode reverseList(ListNode head) {
        ListNode currNode = head;
        if (head == null) {
            return  null;
        }
        ListNode nextCurrNode = currNode.next;
        if (nextCurrNode == null) {
            return currNode;
        }
        ListNode tempNode = nextCurrNode.next;
        if (tempNode == null) {
            currNode.next = null;
            nextCurrNode.next = currNode;
            return nextCurrNode;
        }
        head.next = null;
        while (tempNode.next != null) {
            nextCurrNode.next = currNode;
            currNode = nextCurrNode;
            nextCurrNode = tempNode;
            tempNode = tempNode.next;
        }
        nextCurrNode.next = currNode;
        tempNode.next = nextCurrNode;
        return tempNode;
    }
}