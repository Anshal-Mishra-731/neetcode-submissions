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

public class Codec {
    public void recall(TreeNode root, StringBuilder sb){
        if(root == null){
            sb.append("N,");
            return;
        }

        sb.append(root.val).append(",");
        recall(root.left, sb);
        recall(root.right, sb);
    }

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        recall(root, sb);
        return sb.toString();
    }

    int idx = 0; 
    public TreeNode build(String[] arr){
        if(arr[idx].equals("N")){
            idx++;
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(arr[idx])); 
        idx++; 
        root.left = build(arr); 
        root.right = build(arr); 

        return root;
    }

    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        return build(arr);
    }
}
