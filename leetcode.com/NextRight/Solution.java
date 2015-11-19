/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {    

    public void connect(TreeLinkNode node) {
        if (node == null) {
            return;
        }        

        TreeLinkNode left = node.left;    
        TreeLinkNode right = node.right;      

        while (left != null && right != null) {
            left.next = right;            
            left = left.right;
            right = right.left;
        }       

        connect(node.left);
        connect(node.right);
    }

}