/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }        

        ListNode head2 = reverseCopy(head);        

        while (head != null && head2 != null) {
            if (head.val != head2.val) {
                return false;
			}
            head = head.next;
            head2 = head2.next;
        }        

        return true;
    }    

    private ListNode reverseCopy(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        ListNode next = head.next;       

        ListNode copy = null;
        while (cur != null) {
            copy = new ListNode(cur.val);
            copy.next = prev;

            prev = copy;            

            cur = next;            

            if (next != null) {
                next = next.next;
            }
        }        

        return copy;
    }

}