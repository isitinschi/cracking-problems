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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new LinkedList<>();
        
        if (root != null) {
            addPaths(paths, new StringBuilder(), root);
        }
        
        return paths;
    }
    
    private void addPaths(List<String> paths, StringBuilder builder, TreeNode node) {
        if (!builder.toString().isEmpty()) {
            builder.append("->");
        }
        builder.append(node.val);
            
        if (node.left == null && node.right == null) { // leaf
            paths.add(builder.toString());
        } else {
            if (node.left != null) {
                addPaths(paths, new StringBuilder(builder), node.left);
            }
            if (node.right != null) {
                addPaths(paths, new StringBuilder(builder), node.right);
            }
        }
    }
}