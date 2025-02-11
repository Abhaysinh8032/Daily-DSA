//Check for BST
//https://www.geeksforgeeks.org/problems/check-for-bst/1


class Solution {
    // Function to check whether a Binary Tree is BST or not.
    boolean isBST(Node root) {
        // code here.
        
        
        //arryalist to track the nodes values in ascending order by
        // traversing in order (first left then node then right node)
        ArrayList<Integer> arrlist = new ArrayList<Integer>();
        inOrderTraverse(root,arrlist);
        
        //check for correct order
        
        for(int i = 1; i<arrlist.size();i++){
            if(arrlist.get(i-1)>=arrlist.get(i)){
                return false;
            }
        }
        return true;
    }
    
    void inOrderTraverse(Node node,ArrayList<Integer> arrlist){
        if(node == null){return ;}
        inOrderTraverse(node.left,arrlist);
        arrlist.add(node.data);
        inOrderTraverse(node.right, arrlist);
        
    }
}