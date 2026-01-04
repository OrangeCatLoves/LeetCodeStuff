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


/*
What the fuck, how you can forget how to reverse a linked list properly, the next step is just reassignment can become 1000000000 lines bro. Anyway the concise solution from AI is at the bottom.
*/
class Solution {
    public void reorderList(ListNode head) {
        int n = 1;
        ListNode scoutLength = head;
        while (scoutLength.next != null) {
            scoutLength = scoutLength.next;
            n++;
        }
        ListNode listBuilder = head;
        ListNode p1a = head;
        ListNode p1b = head.next;
        ListNode p2a = head;
        ListNode p2b = head;
        ListNode slow = head;
        ListNode fast = head.next;
        if (n <= 5) {
            if (n == 1 || n == 2) {
                return;
            } else if (n == 3) {
                ListNode p1c = p1b.next;
                p1a.next = p1c;
                p1c.next = p1b;
                p1b.next = null;
                return;
            } else if (n == 4) {
                ListNode p1c = p1b.next;
                ListNode p1d = p1c.next;
                p1a.next = p1d;
                p1d.next = p1b;
                p1b.next = p1c;
                p1c.next = null;
                return;
            } else if (n == 5) {
                ListNode p1c = p1b.next;
                ListNode p1d = p1c.next;
                ListNode p1e = p1d.next;
                p1a.next = p1e;
                p1e.next = p1b;
                p1b.next = p1d;
                p1d.next = p1c;
                p1c.next = null;
                return;
            }
            
        }
        boolean switchList = true;
        boolean firstTime = true;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // Reset fast pointer to point to the last element
        if (fast == null) {
            fast = head;
            while (fast.next != null) {
                fast = fast.next;
            }
        }
        /* At this point, the slow pointer is the second half of the list 
        and fast pointer should be at the end of the list
        */
        System.out.println(slow.val);
        System.out.println(fast.val);
        

        ListNode p3a = slow.next;
        ListNode p3b = p3a.next;
        ListNode p3c = p3b.next;
        slow.next = null;
        p3a.next = null;
        while (p3c.next != null) {
            p3b.next = p3a;
            p3a = p3b;
            p3b = p3c;
            p3c = p3c.next;
        }
        p3c.next = p3b;
        p3b.next = p3a;
        // Debugging section to ensure modification of second half of list is correct
        ListNode firstHalf = head;
        ListNode secondHalf = p3c;
        while (firstHalf != null) {
            System.out.println(firstHalf.val);
            System.out.println("First");
            firstHalf = firstHalf.next;
        }
        while (secondHalf != null) {
            System.out.println(secondHalf.val);
            System.out.println("Second");
            secondHalf = secondHalf.next;
        }
        // At this juncture, p3c should be pointing at the head of the second half of list
        // Start constructing the final answer from here
        p2a = p3c;
        p2b = p2a.next;
        while (p1b.next != null && p2b.next != null) {
            if (switchList) {
                listBuilder.next = p2a;
                listBuilder = listBuilder.next;
                if (firstTime) {
                    p1a = p1b;
                    p1b = p1b.next;
                    firstTime = false;
                }
                p2a = p2b;
                p2b = p2b.next;
                switchList = !switchList;
            } else {
                listBuilder.next = p1a;
                listBuilder = listBuilder.next;
                if (firstTime) {
                    p2a = p2b;
                    p2b = p2b.next;
                    firstTime = false;
                }
                p1a = p1b;
                p1b = p1b.next;
                switchList = !switchList;
            }
        }
        if (p1b.next == null) {
            listBuilder.next = p2a;
            listBuilder = listBuilder.next;
            p2a = p2b;
            p2b = p2b.next;
            listBuilder.next = p1a;
            listBuilder = listBuilder.next;
            listBuilder.next = p2a;
            listBuilder = listBuilder.next;
            listBuilder.next = p1b;
            listBuilder = listBuilder.next;
            listBuilder.next = p2b;
        } else if (p2b.next == null) {
            listBuilder.next = p1a;
            listBuilder = listBuilder.next;
            p1a = p1b;
            p1b = p1b.next;
            listBuilder.next = p2a;
            listBuilder = listBuilder.next;
            listBuilder.next = p1a;
            listBuilder = listBuilder.next;
            listBuilder.next = p2b;
            listBuilder = listBuilder.next;
            listBuilder.next = p1b;
        }
        return;
    }
}

/*
class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        // find middle
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // reverse second half
        ListNode second = slow.next;
        slow.next = null;
        ListNode prev = null, cur = second;
        while (cur != null) {
            ListNode nxt = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nxt;
        }
        second = prev;

        // merge
        ListNode first = head;
        while (second != null) {
            ListNode fNext = first.next;
            ListNode sNext = second.next;

            first.next = second;
            second.next = fNext;

            first = fNext;
            second = sNext;
        }
    }
}
*/
