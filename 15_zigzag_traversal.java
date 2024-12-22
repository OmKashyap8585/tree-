class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null )
            return ans;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean leftToRight = false;
        while (!q.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<>();
            int levelSize = q.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = q.poll();
                if (leftToRight) {
                    list.add(0, node.val);
                } else {
                    list.add(node.val);
                }
                if(node.left!=null) q.offer(node.left);
                if(node.right!=null) q.offer(node.right);
            }
            leftToRight = !leftToRight;
            ans.add(list);
        }
        return ans;
    }
}
