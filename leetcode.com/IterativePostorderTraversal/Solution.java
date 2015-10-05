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

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }        

        Stack<TreeNode> in = new Stack<>();
        Stack<Integer> out = new Stack<>();     

        in.push(root);
        while (!in.isEmpty()) {
            TreeNode node = in.pop();
            out.push(node.val);
            if (node.left != null) {
                in.push(node.left);
            }
            if (node.right != null) {
                in.push(node.right);
            }
        }       

        while (!out.isEmpty()) {
            list.add(out.pop());
        }        

        return list;
    }

}