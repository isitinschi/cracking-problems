class Solution {
    public int solution(Tree T) {
        return findMaxDepth(T, 0);
    }
    
    private int findMaxDepth(Tree node, int depth) {
        if (node == null) {
            return depth - 1;    
        } else {
            int left = findMaxDepth(node.l, depth + 1);
            int right = findMaxDepth(node.r, depth + 1);
            
            if (left > right) {
                return left;    
            } else {
                return right;    
            }
        }
    }
}