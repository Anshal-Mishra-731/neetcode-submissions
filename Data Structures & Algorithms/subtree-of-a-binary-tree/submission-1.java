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
    public boolean equal(TreeNode p, TreeNode q){
        if(p == null && q == null){
            return true;
        }
        if(p == null || q == null){
            return false;
        }
        if(p.val != q.val){
            return false;
        }

        return equal(p.left, q.left) && equal(p.right, q.right);
    } 

    public boolean checkSub (TreeNode root, TreeNode subRoot){
        if(root == null){
            return false;
        }
        if(equal(root, subRoot)){
            return true;
        }
        return checkSub(root.left, subRoot) || checkSub(root.right, subRoot);
    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == subRoot){
            return true;
        }
        return checkSub(root, subRoot);
    }
}
