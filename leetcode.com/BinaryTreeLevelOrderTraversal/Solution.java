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

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<List<Integer>>();
        }        

        List<List<Integer>> list = new ArrayList<>();
        levelOrder(root, 0, list);
        return list;
    }    

    private void levelOrder(TreeNode node, int level, List<List<Integer>> list) {
        if (node == null) {
            return;
        }
        if (level == list.size()) {
            list.add(new ArrayList<Integer>());
        }
        List<Integer> levelList = list.get(level);
        levelList.add(node.val);
        levelOrder(node.left, level + 1, list);
        levelOrder(node.right, level + 1, list);
    }

}