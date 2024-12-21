class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        TreeNode curr = root;
        while( curr!=null||!st.isEmpty()){
            //Process the left nodes
            while(curr!=null){
                st.push(curr);
                curr = curr.left;
            }
            //process the node
            curr = st.pop();
            ans.add(curr.val);

            //process right node 
            curr=curr.right;
        }
        return ans ;
    }
}
