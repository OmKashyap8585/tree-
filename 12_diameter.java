class Solution {
    private int diameter = 0;
    public int height(TreeNode root){
        if(root==null){
            return 0;
        }
        int l = height(root.left);
        int r = height(root.right);
        diameter = Math.max(diameter,l+r);
        return Math.max(l,r)+1;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return diameter;
    }
}



// class Solution {
//     class Pair{
//         int d;
//         int h;
//         Pair(int d , int h) {
//             this.d=d;
//             this.h=h;
//         }
//     }
//     public Pair diameter(TreeNode root, Pair p){
//         if(root == null){
//             return new Pair(0,0);
//         }
//         int l = diameter(root.left,p).h;
//         int r = diameter(root.right,p).h;
//         p.d = Math.max(p.d , l+r);
//         p.h = Math.max(l,r)+1;
//         return p;
//     }
//     public int diameterOfBinaryTree(TreeNode root) {
//         Pair p = new Pair(0,0);
//         return diameter(root,p).d; 
//     }
// }
