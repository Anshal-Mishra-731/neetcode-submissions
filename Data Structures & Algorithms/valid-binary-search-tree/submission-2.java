/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    boolean ans = true;
    public void solution(TreeNode root, long minAll, long maxAll){
        if(root == null){
            return;
        }
        if(root.val <= minAll || root.val >= maxAll){
            ans = false;
            return;
        }
        solution(root.right, root.val, maxAll); 
        solution(root.left, minAll, root.val);
    }
    public boolean isValidBST(TreeNode root) {
        solution(root, Long.MIN_VALUE, Long.MAX_VALUE);
        return ans;
    }
}
