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
    boolean bool = true;
    public int depthmax(TreeNode root){
        if(root == null){
            return 0;
        }

        if(Math.abs(depthmax(root.left) - depthmax(root.right)) > 1){
            bool = false;
        }

        return 1 + Math.max(depthmax(root.left), depthmax(root.right));
    }

    public boolean isBalanced(TreeNode root) {
        depthmax(root);
        return bool;
    }
}
