class Solution {
    int cnt = 0;
    int ans = 0;
    public void insolution(TreeNode root, int k){
        if(root == null){
            return;
        }
        insolution(root.left, k);
        cnt++;
        if(cnt == k){
            ans = root.val;
            return;
        }
        insolution(root.right, k);
    }

    public int kthSmallest(TreeNode root, int k) {
        insolution(root, k);
        return ans;
    }
}