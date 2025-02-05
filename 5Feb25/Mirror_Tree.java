//Mirror Tree
//https://www.geeksforgeeks.org/problems/mirror-tree/1


class Solution {
    // Function to convert a binary tree into its mirror tree.
    void mirror(Node node) {
        // Your code here
        if(node == null){return ;}
        
        Node l = node.left;
        node.left = node.right;
        node.right = l;
        
        mirror(node.left);
        mirror(node.right);
    }
}
