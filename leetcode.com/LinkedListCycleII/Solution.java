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

    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode cur = head;
        ListNode runner = head;      

        boolean foundCycle = false;
        while (!foundCycle && runner != null && runner.next != null) {
            cur = cur.next;
            runner = runner.next.next;
            if (cur == runner) {
                foundCycle = true;
                break;
            }
        }        

        if (foundCycle) {
            cur = head;
            while (cur != runner) {
                cur = cur.next;
                runner = runner.next;
            }
            return cur;
        }        

        return null;
    }

}