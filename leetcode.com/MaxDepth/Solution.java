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

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }        

        return maxDepth(root, 1);
    }    

    private int maxDepth(TreeNode n, int depth) {
        int maxDepth = depth;        

        if (n.left != null) {
            maxDepth = Math.max(maxDepth, maxDepth(n.left, depth + 1));
        }
        if (n.right != null) {
            maxDepth = Math.max(maxDepth, maxDepth(n.right, depth + 1));
        }       

        return maxDepth;
    }    

}