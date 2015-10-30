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

    public int sumNumbers(TreeNode root) {
        return sumDFT(root, 0);
    }    

    private int sumDFT(TreeNode node, int number) {
        if (node == null) {
            return 0;
        } else {
            number = number*10 + node.val;            

            if (node.left == null && node.right == null) {
                return number;
            }            

            int sum = 0;
            if (node.left != null) {
                sum += sumDFT(node.left, number);
            }
            if (node.right != null) {
                sum += sumDFT(node.right, number);
            }            

            return sum;
        }
    }

}