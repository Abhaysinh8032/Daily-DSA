//https://www.geeksforgeeks.org/problems/boundary-traversal-of-binary-tree/1
class Solution {
    // Function to print the leaves of a binary tree
    void printLeaves(Node node, ArrayList<Integer> res) {
        if (node != null) {
            printLeaves(node.left,
                        res); // recursively calling the function on the left child

            if (node.left == null &&
                node.right == null) // checking if the node is a leaf (no children)
                res.add(node.data); // adding the leaf node to the result list

            printLeaves(node.right,
                        res); // recursively calling the function on the right child
        }
    }

    // Function to print the left boundary of a binary tree
    void printBoundaryLeft(Node node, ArrayList<Integer> res) {
        if (node != null) {
            if (node.left != null) // if the left child exists
            {
                res.add(node.data); // adding the current node to the result list
                printBoundaryLeft(
                    node.left,
                    res); // recursively calling the function on the left child
            } else if (node.right !=
                       null) // if the left child doesn't exist but the right child does
            {
                res.add(node.data); // adding the current node to the result list
                printBoundaryLeft(
                    node.right,
                    res); // recursively calling the function on the right child
            }
        }
    }

    // Function to print the right boundary of a binary tree
    void printBoundaryRight(Node node, ArrayList<Integer> res) {
        if (node != null) {
            if (node.right != null) // if the right child exists
            {
                printBoundaryRight(
                    node.right,
                    res); // recursively calling the function on the right child
                res.add(node.data); // adding the current node to the result list
            } else if (node.left !=
                       null) // if the right child doesn't exist but the left child does
            {
                printBoundaryRight(
                    node.left,
                    res); // recursively calling the function on the left child
                res.add(node.data); // adding the current node to the result list
            }
        }
    }

    // Function to calculate the boundary of a binary tree
    ArrayList<Integer> boundaryTraversal(Node node) {
        ArrayList<Integer> res =
            new ArrayList<Integer>(0); // creating an empty result list

        if (node != null) res.add(node.data); // adding the root node to the result list

        printBoundaryLeft(node.left, res); // printing the left boundary of the tree

        printLeaves(node.left, res);  // printing the leaves of the left subtree
        printLeaves(node.right, res); // printing the leaves of the right subtree

        printBoundaryRight(node.right, res); // printing the right boundary of the tree

        return res; // returning the final result list
    }
}