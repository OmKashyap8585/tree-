class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == p || root == q) return root;
        if(root==null )return null;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) { return root;}
        if(left!=null && right==null) {return left;}
        if(left==null && right!=null){ return right;}
        return null;
    }
}
