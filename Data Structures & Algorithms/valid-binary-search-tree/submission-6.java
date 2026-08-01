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
    public boolean solution(TreeNode root, Integer upperl, Integer lowerl){
        if(root == null){
            return true;
        }
        if(root.val <= lowerl || root.val >= upperl){
            return false;
        }
        return solution(root.right, upperl, root.val) && solution(root.left, root.val, lowerl);
    }
    public boolean isValidBST(TreeNode root) {
        return solution(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }
}
