//Construct Tree from Inorder & Preorder
//https://www.geeksforgeeks.org/problems/construct-tree-1/1

class Solution {
    // Map to store the index of each element in the inorder array
    private static HashMap<Integer, Integer> indexMap;

    // Recursive function to build a binary tree using inorder and preorder traversal
    // arrays
    public static Node buildUtil(int inorder[], int preorder[], int inStart,
                                 int preStart, int n) {
        if (n == 0) return null;

        // Create a new node with the value at preStart index of the preorder array
        Node root = new Node(preorder[preStart]);

        // Get the index of the root value in the inorder array from the map
        int i = indexMap.get(preorder[preStart]);

        // Recursively build the left subtree
        root.left = buildUtil(inorder, preorder, inStart, preStart + 1, i - inStart);

        // Recursively build the right subtree
        root.right = buildUtil(inorder, preorder, i + 1, preStart + (i - inStart) + 1,
                               n - (i - inStart) - 1);

        return root;
    }

    // Function to build a binary tree using inorder and preorder traversal arrays
    public static Node buildTree(int inorder[], int preorder[]) {
        int n = inorder.length;

        // Initialize the map and store the indexes of inorder elements
        indexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }

        // Call the recursive function to build the tree
        return buildUtil(inorder, preorder, 0, 0, n);
    }
}