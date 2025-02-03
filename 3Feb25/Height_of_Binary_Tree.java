//https://www.geeksforgeeks.org/problems/height-of-binary-tree/1
//Height of Binary Tree



class Solution {
    // Function to find the height of a binary tree.
    int height(Node node) {
        // code here
        if(node == null){return 0;}
        int h = helper(node, 0);
        return h;
    }
    
    int helper(Node node , int h){
        if(node.right == null && node.left == null){return h;}
        
        int l = h;
        int r = h;
        
        if(node.left != null){
            l =helper(node.left, h+1);
        }
        if(node.right != null){
            r =helper(node.right, h+1);
        }
        return Math.max(l,r);
    }
}

