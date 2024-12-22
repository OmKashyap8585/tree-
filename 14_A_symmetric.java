class Solution {
    public boolean helper(TreeNode p , TreeNode q){
        if(p==null&&q==null)return true;
        if(p==null||q==null)return false;
        if(p.val!=q.val)return false;
        boolean left = helper(p.left,q.right);
        boolean right = helper(p.right,q.left);
        return left && right;
    }
    public boolean isSymmetric(TreeNode root) {
         return helper(root.left,root.right);
    }
}
