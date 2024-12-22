class Solution {
    private int leaf = 0;
    public void traversal(TreeNode root){
        if(root==null)return;
        leaf++;
        traversal(root.left);
        traversal(root.right);
    }
    public int countNodes(TreeNode root) {
        // if(root==null) return 0;
        traversal(root);
        return leaf;
    }
}
