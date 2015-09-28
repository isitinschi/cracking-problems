import java.util.Queue;
import java.util.LinkedList;

/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */

public class Solution {    

    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }       

        Queue<TreeLinkNode> queue = new LinkedList<>();
        queue.add(root);
        int count = 0;
        int pow = 1;
        while (!queue.isEmpty()) {
            TreeLinkNode n = queue.poll();
            ++count;
            if (count != Math.pow(2, pow) - 1) {
                n.next = queue.peek();
            } else {
                ++pow;
            }
            if (n.left != null) { // enough, because we have perfectly balanced binary tree
                queue.add(n.left);
                queue.add(n.right);
            }
        }
    }

}