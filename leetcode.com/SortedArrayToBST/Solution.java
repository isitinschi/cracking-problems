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

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }      

        TreeNode root = buildBST(nums, 0, nums.length - 1);
        return root;
    }   

    private TreeNode buildBST(int [] nums, int start, int end) {
        if (start > end) {
            return null;
        }        

        int m = start + (end - start) / 2;
        int val = nums[m];
		
        TreeNode node = new TreeNode(val);
        node.left = buildBST(nums, start, m - 1);
        node.right = buildBST(nums, m + 1, end);       

        return node;
    }

}