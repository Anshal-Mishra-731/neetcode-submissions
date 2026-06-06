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

    int diameter = 0;
    public int depth(TreeNode root){
        if(root == null){
            return 0;
        }

        diameter = Math.max(diameter, depth(root.left) + depth(root.right));

        return 1 + Math.max(depth(root.left), depth(root.right));
    }
    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return diameter;
    }
}
