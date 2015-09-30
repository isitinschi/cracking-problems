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

    public TreeNode invertTree(TreeNode root) {
        invertNode(root);
        return root;
    }    

    private void invertNode(TreeNode node) {
        if (node != null) {
            TreeNode left = node.left;
            node.left = node.right;
            node.right = left;            

            invertNode(node.left);
            invertNode(node.right);
        }
    }

}