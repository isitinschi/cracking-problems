/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {

    public void deleteNode(ListNode node) {
        if (node == null) {
            return;
        }        

        ListNode n = node;
        while (n.next != null) {
            n.val = n.next.val;
            if (n.next.next == null) {
                n.next = null;
            } else {
                n = n.next;
            }
        }
    }

}