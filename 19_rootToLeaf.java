public void helper(TreeNode root, ArrayList<ArrayList<Integer>> list, ArrayList<Integer> ans) {
    if (root.left == null && root.right == null) {
        list.add(new ArrayList<>(ans)); // Make sure to add a copy of 'ans'
        return;
    }
    if (root.left != null) {
        ans.add(root.left.val);
        helper(root.left, list, ans);
        ans.remove(ans.size() - 1); // Remove the last added element
    }
    if (root.right != null) {
        ans.add(root.right.val);
        helper(root.right, list, ans);
        ans.remove(ans.size() - 1); // Remove the last added element
    }
}

public List<String> binaryTreePaths(TreeNode root) {
    ArrayList<Integer> ans = new ArrayList<>();
    ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    if (root != null) {
        ans.add(root.val); // Add root value to the ans
        helper(root, list, ans);
    }
    
    ArrayList<String> stringList = new ArrayList<>();
    for (ArrayList<Integer> subList : list) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < subList.size(); i++) {
            sb.append(subList.get(i));
            if (i < subList.size() - 1) {
                sb.append("->");
            }
        }
        stringList.add(sb.toString());
    }
    return stringList; // Return the final list of strings
}
