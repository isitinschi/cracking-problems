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

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return minDepth(root, 1);
    }    

    private int minDepth(TreeNode node, int depth) {
        if (node == null) {
            return Integer.MAX_VALUE;
        } else if (node.left == null && node.right == null) {
            return depth;
        } else {
            int min = Integer.MAX_VALUE;
            min = Math.min(min, minDepth(node.left, depth + 1));
            min = Math.min(min, minDepth(node.right, depth + 1));
            return min;
        }
    }

}