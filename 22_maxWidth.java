class Solution {
    class Pair {
        TreeNode node;
        int col;
        Pair(TreeNode node, int col) {
            this.node = node;
            this.col = col;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;

        int maxWidth = 0;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0));
        
        while (!q.isEmpty()) {
            int levelSize = q.size();
            int start = q.peek().col; 
            int end = 0; 
            
            for (int i = 0; i < levelSize; i++) {
                Pair current = q.poll();
                TreeNode node = current.node;
                int col = current.col;
                end = col;
                
                if (node.left != null) q.offer(new Pair(node.left, 2 * col));
                if (node.right != null) q.offer(new Pair(node.right, 2 * col + 1));
            }
            maxWidth = Math.max(maxWidth, end - start + 1); 
        }
        return maxWidth;
    }
}
