/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }        

        ListNode cur = head;
        head = cur.next;
        while (cur != null && cur.next != null) {
            ListNode temp = cur.next.next;
            cur.next.next = cur;
            cur.next = temp;           

            if (temp != null && temp.next != null) {
                cur.next = temp.next;
            }

            cur = temp;
        }        

        return head;
    }

}