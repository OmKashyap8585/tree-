class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null)
            return ans;
        Stack<TreeNode> st = new Stack<>();
        TreeNode curr = root;
        TreeNode temp =  null;
         while (curr != null || !st.isEmpty()) {
            //process left 
            while (curr != null) {
                st.push(curr);
                curr = curr.left;
            }
            curr = st.peek();
            if (curr.right == null || curr.right == temp) {
                st.pop();
                ans.add(curr.val);
                temp = curr;
                curr = null;
            } else {
                curr = curr.right;
            }
        }
        return ans;
    }
}
