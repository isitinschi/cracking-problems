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

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return new LinkedList<Integer>();
        }        

        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new LinkedList<>();
        stack.push(root);
        TreeNode n = root;
        while (!stack.isEmpty()) {
            if (n == null) {
                n = stack.pop();
            }

            while (n.left != null) {
                stack.push(n.left);
                n = n.left;
            }

            if (!stack.isEmpty()) {
                n = stack.pop();
                list.add(n.val);
                while (n.right == null && !stack.isEmpty()) {
                    n = stack.pop();
                    list.add(n.val);
                }

                if (n.right != null) {
                    n = n.right;
                    stack.push(n);
                }    
            }
        }        

        return list;
    }

}