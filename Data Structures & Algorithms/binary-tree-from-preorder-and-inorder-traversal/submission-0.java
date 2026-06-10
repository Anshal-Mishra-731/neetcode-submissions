/*
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
    int idx = 0;
    public TreeNode build(int[] preorder, Map<Integer, Integer> mp, int l, int r){
        if(l > r){
            return null;
        }
        int val = preorder[idx++];

        TreeNode root = new TreeNode(val);
        int mid = mp.get(val); 

        root.left = build(preorder, mp, l, mid - 1); 
        root.right = build(preorder, mp, mid + 1, r);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> mp = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            mp.put(inorder[i], i);
        }
        return build(preorder, mp, 0, inorder.length - 1);
    }
}
