//https://www.geeksforgeeks.org/problems/diameter-of-binary-tree/1



class Solution {
    int diameter(Node root) {
        // Your code here
        if(root == null){return 0;}
        
        int[] ans = helper(root,0);
        return Math.max(ans[0],ans[1]);
    }
    
    int[] helper(Node node, int h){
        int[] ans = {0,0};
        
        // ans[0] zero index for diameter at each node
        // ans[1] for height of given traverse
        if(node == null){return ans;}
        
        if(node.left == null && node.right== null){
            ans[1] = h;
            return ans;
        }
        
        int[] l  = {0,h};
        int[] r  = {0,h};
        
        if(node.left !=null){
            l = helper(node.left,h+1);
        }
        else{
            r = helper(node.right , h+1);
            return r;
        }
        if(node.right != null){
            r = helper(node.right , h+1);
        }
        else{
            return l;
        }
        
        ans[1] = Math.max(l[1],r[1]);
        ans[0] = Math.max(l[0],Math.max(r[0],l[1]+r[1]-2*h));
        return ans;
    }
}
