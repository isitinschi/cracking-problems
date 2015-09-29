/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
public class Solution {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        return isSameNode(p, q);
    }   

    private boolean isSameNode(TreeNode n1, TreeNode n2) {
        if (n1 == null && n2 == null) {
            return true;
        }
        if (n1 == null || n2 == null) {
            return false;
        }
        if (n1.val != n2.val) {
            return false;
        }  

        boolean sameLeft = isSameNode(n1.left, n2.left);
        boolean sameRight = isSameNode(n1.right, n2.right);       

        return sameLeft && sameRight;
    }    

}