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

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root != null) {
            levelOrderBottom(root, list, 0);
        }        

        Collections.reverse(list);        

        return list;
    }    

    private void levelOrderBottom(TreeNode node, List<List<Integer>> list, int depth) {
        if (list.size() == depth) {
            list.add(new ArrayList<Integer>());
        }        

        if (node.left != null) {
            levelOrderBottom(node.left, list, depth + 1);
        }
        if (node.right != null) {
            levelOrderBottom(node.right, list, depth + 1);
        }        

        list.get(depth).add(node.val);
    }    

}