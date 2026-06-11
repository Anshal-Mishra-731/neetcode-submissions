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

    int ans = Integer.MIN_VALUE; 
    public int dfs(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right); 

        ans = Math.max(ans, root.val + Math.max(0,left) + Math.max(0,right)); 

        return root.val + Math.max(Math.max(0,left), Math.max(0,right));
    }

    public int maxPathSum(TreeNode root) {
        dfs(root); 
        return ans;
    }
}
