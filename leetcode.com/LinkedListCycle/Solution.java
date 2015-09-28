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

        ListNode node = head;
        ListNode runner = head.next;
        while(runner != null && runner.next != null) {
            if (node == runner) {
                return true;
            }
            node = node.next;
            runner = runner.next.next;
        }

        return false;
    }

}