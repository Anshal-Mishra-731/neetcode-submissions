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
    public boolean compare(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return compare(p.left, q.left) && compare(p.right, q.right);
    }

    boolean nah = false;
    public void isIt(TreeNode root, TreeNode subRoot){
        if(root == null){
            return;
        }
        if(compare(root, subRoot) == true){
            nah = true;
            return;
        }
        isIt(root.right, subRoot); 
        isIt(root.left, subRoot);
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        isIt(root, subRoot);
        return nah;
    }
}
