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

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }        

        return isBalanced(root.left) && 
            isBalanced(root.right) && 
            Math.abs(height(root.left, 0) - height(root.right, 0)) < 2;
    }    

    private int height(TreeNode node, int cur) {
        if (node == null) {
            return cur;
        } else {
            int height = Math.max(height(node.left, cur + 1),
                height(node.right, cur + 1));
            return height;
        }
    }    

}