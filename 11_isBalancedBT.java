// class Solution {
//     public int maxDepth(TreeNode root) {
//         if(root == null) {
//             return 0;
//         }
//         return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
//     }
//     public boolean isBalanced(TreeNode root) {
//         if(root == null) return true;
//         int lh = maxDepth(root.left);
//         int rh = maxDepth(root.right);

//         if(Math.abs(lh-rh) > 1){
//             return false;
//         }
//         boolean left = isBalanced(root.left);
//         boolean right = isBalanced(root.right);
//         if(left==false || right == false){
//             return false;
//         }
//         return true;
//     }
// }


//^^ O(n^2)


class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = maxDepth(root.left);
        if (l == -1)
            return -1; // Propagate imbalance from the left subtree
        int r = maxDepth(root.right);
        if (r == -1)
            return -1; // Propagate imbalance from the right subtree
        if (Math.abs(l - r) > 1)
            return -1; // Check current node's balance
        return Math.max(l, r) + 1; // Return depth if balanced
    }

    public boolean isBalanced(TreeNode root) {
        return maxDepth(root) != -1;
    }

}


// tc : O(n

