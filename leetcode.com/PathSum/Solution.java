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

    public boolean hasPathSum(TreeNode root, int sum) {
        return hasPathSum(root, sum, 0);
    }    

    private boolean hasPathSum(TreeNode node, int target, int sum) {
        if (node != null) {
            sum += node.val;
            
            if (node.left == null && node.right == null) {
                return sum == target;
            }            

            return hasPathSum(node.left, target, sum) || hasPathSum(node.right, target, sum);
        }        

        return false;
    }

}