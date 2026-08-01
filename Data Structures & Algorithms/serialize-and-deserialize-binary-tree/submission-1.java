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

    public StringBuilder convert(TreeNode root, StringBuilder sb){
        if(root == null){
            sb.append("N").append(",");
            return sb;
        }

        sb.append(root.val).append(",");
        convert(root.left, sb); 
        convert(root.right, sb); 

        return sb;
    }

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder(); 
        return convert(root, sb).toString();
    }

    int idx = 0;
    public TreeNode build(String[] arr){
        String a = arr[idx++];
        if(a.equals("N")){
            return null;
        }

        TreeNode curr = new TreeNode(Integer.parseInt(a));
        curr.left = build(arr); 
        curr.right = build(arr);

        return curr;
    }
    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        return build(arr);
    }
}
