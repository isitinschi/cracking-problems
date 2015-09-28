import java.util.Stack;
import java.util.List;
import java.util.LinkedList;

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

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return new LinkedList<Integer>();
        }        

        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode n = stack.pop();
            list.add(n.val);
            if (n.right != null) {
                stack.push(n.right);
            }
            if (n.left != null) {
                stack.push(n.left);
            }
        }        

        return list;
    }

}