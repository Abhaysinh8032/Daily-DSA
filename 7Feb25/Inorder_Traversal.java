//https://www.geeksforgeeks.org/problems/inorder-traversal/1

class Solution {
    // Function to return a list containing the inorder traversal of the tree.
    ArrayList<Integer> inOrder(Node root) {
        // Code
        ArrayList<Integer> ans =  new ArrayList<Integer>();
         helper(ans,root);
         return ans;
    }
    
    void helper( ArrayList<Integer> ans , Node node){
        if(node == null){return ;}
        
        if(node.left != null){
            helper(ans,node.left);
            
        }
        ans.add(node.data);
        if(node.right!= null){
            helper(ans,node.right);
        }
    }
    
    
}