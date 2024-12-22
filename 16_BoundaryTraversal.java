import java.util.ArrayList;

// Node class to represent a binary tree node
class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class BoundaryTraversal {
    public static void main(String[] args) {
        // Constructing the binary tree
        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.left.left = new Node(4);
        root.left.right = new Node(12);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);
        root.right.left = new Node(25);

        // Get the boundary traversal and print it
        ArrayList<Integer> boundary = boundaryTraversal(root);
        System.out.println(boundary);
    }

    // Function to perform boundary traversal of the binary tree
    public static ArrayList<Integer> boundaryTraversal(Node root) {
        ArrayList<Integer> result = new ArrayList<>();

        // If the tree is empty, return an empty list
        if (root == null) return result;

        // Add the root node (always part of the boundary)
        result.add(root.data);

        // Add the left boundary (excluding leaves)
        addLeftBoundary(root.left, result);

        // Add all the leaf nodes
        addLeaves(root.left, result);
        addLeaves(root.right, result);

        // Add the right boundary (excluding leaves) in reverse order
        addRightBoundary(root.right, result);

        return result;
    }

    // Function to add the left boundary nodes (excluding leaves) to the result
    private static void addLeftBoundary(Node node, ArrayList<Integer> result) {
        while (node != null) {
            // Add only if it's not a leaf node
            if (node.left != null || node.right != null)
                result.add(node.data);

            // Move to the next node (prefer left child)
            node = (node.left != null) ? node.left : node.right;
        }
    }

    // Function to add all the leaf nodes to the result
    private static void addLeaves(Node node, ArrayList<Integer> result) {
        if (node == null) return;

        // Recursively traverse the left and right subtrees
        addLeaves(node.left, result);
        
        // Add to result if it's a leaf node
        if (node.left == null && node.right == null)
            result.add(node.data);
        
        addLeaves(node.right, result);
    }

    // Function to add the right boundary nodes (excluding leaves) to the result
    private static void addRightBoundary(Node node, ArrayList<Integer> result) {
        ArrayList<Integer> temp = new ArrayList<>(); // Temporary list to store right boundary nodes

        while (node != null) {
            // Add only if it's not a leaf node
            if (node.left != null || node.right != null)
                temp.add(node.data);

            // Move to the next node (prefer right child)
            node = (node.right != null) ? node.right : node.left;
        }

        // Add the right boundary nodes in reverse order
        for (int i = temp.size() - 1; i >= 0; i--) {
            result.add(temp.get(i));
        }
    }
}
