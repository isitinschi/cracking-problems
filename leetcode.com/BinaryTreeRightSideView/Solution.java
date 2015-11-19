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

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> view = new LinkedList<>();
        
        if (root != null) {
            view(root, view, 0, true);
        }        

        return view;
    }    

    private void view(TreeNode node, List<Integer> view, int level, boolean forceAdd) {
        if (forceAdd) {
            view.add(node.val);
        } else if (level == view.size()) {
            view.add(node.val);
        }
        if (node.right != null) {
            view(node.right, view, level + 1, forceAdd);
        }
        if (node.left != null) {
            view(node.left, view, level + 1, false);
        }
    }

}