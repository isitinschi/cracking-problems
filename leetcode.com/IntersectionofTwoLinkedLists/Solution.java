/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }        

        int lengthA = length(headA);
        int lengthB = length(headB);        

        if (lengthA > lengthB) {
            int diff = lengthA - lengthB;
            while (diff > 0) {
                headA = headA.next;
                --diff;
            }
        } else if (lengthB > lengthA) {
            int diff = lengthB - lengthA;
            while (diff > 0) {
                headB = headB.next;
                --diff;
            }
        }       

        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }        

        return headA;
    }    

    private int length(ListNode head) {
        int length = 0;        

        while (head != null) {
            ++length;
            head = head.next;
        }        

        return length;
    } 

}