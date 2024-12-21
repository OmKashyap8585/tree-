class Solution {
    private int max = -1001;
    public int helper(TreeNode root){
        if(root==null)return 0;
        int left = Math.max(0, helper(root.left));
        int right = Math.max(0, helper(root.right));
        max = Math.max(max,left+right+root.val);
        return Math.max(left,right)+root.val;
    }
    public int maxPathSum(TreeNode root) {
        int x = helper(root);
        return Math.max(max,x);
    }
}
