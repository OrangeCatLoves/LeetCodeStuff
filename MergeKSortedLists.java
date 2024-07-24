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

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode ans = new ListNode();
        ListNode p = ans;
        while (!allEmpty(lists)) {
            ListNode next = getMin(lists);
            System.out.println("Building: " + next.val);
            p.next = next;
            p = p.next;
        }
        return ans.next;
    }

    public boolean allEmpty(ListNode[] lists) {
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                return false;
            }
        }
        return true;
    }

    public ListNode getMin(ListNode[] lists) {
        ListNode currNode = new ListNode(Integer.MAX_VALUE);
        int index = 0;
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null && lists[i].val < currNode.val) {
                currNode = lists[i];
                index = i;
                System.out.println("From list: " + index + " Val: " + currNode.val);
            }
        }
        if (lists[index] != null) {
            lists[index] = lists[index].next;
        }
        System.out.println("Final From list: " + index + " Val: " + currNode.val);
        return currNode;
    }
}