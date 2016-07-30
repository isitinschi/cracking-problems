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
    
    private int count = 0;
    
    public int kthSmallest(TreeNode root, int k) {
        if (root == null) {
            return -1;
        }
        return go(root, k);
    }
    
    private Integer go(TreeNode node, int k) {
        Integer val = null;
        
        if (node.left != null) {
            val = go(node.left, k);
        }
        
        if (val == null) {
            count += 1;
            if (count == k) {
                return node.val;
            }
            
            if (node.right != null) {
                val = go(node.right, k);
            }
        }
        
        return val;
    }
}