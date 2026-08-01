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
    public void solution(TreeNode root, Integer upperl, Integer lowerl){
        if(root == null){
            return;
        }
        if(root.val <= lowerl || root.val >= upperl){
            ans = false;
            return;
        }
        solution(root.right, upperl, root.val); 
        solution(root.left, root.val, lowerl);
    }
    public boolean isValidBST(TreeNode root) {
        solution(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
        return ans;
    }
}
