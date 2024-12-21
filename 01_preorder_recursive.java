class Solution {
    public void preorder(TreeNode root, ArrayList<Integer> ans){
        if(root == null) return ;
        ans.add(root.val);
        preorder(root.left,ans);
        preorder(root.right,ans);

    }
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>(); 
        preorder(root,ans);
        return ans;
    }
}
