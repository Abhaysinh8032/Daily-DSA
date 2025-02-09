https://www.geeksforgeeks.org/problems/maximum-path-sum-from-any-node/1

Maximum path sum from any node



// used the dfs approach
// calculated the sum from leaf to root
class Solution {
    // Function to return maximum path sum from any node in a tree.
    int findMaxSum(Node node) {
        // your code goes here
        if(node == null){return Integer.MIN_VALUE;}
        max = node.data;
        int ans = helper(node);
        
        ans = Math.max(ans,max);
        return ans;
    }
    int max = 0;
    int helper(Node node){
        if(node == null){return 0;}
       
        int l = 0;
        int r = 0;
        int ans = node.data;//for single path
        
        int cans = node.data;//if given node is root of ans path
        if(node.left != null){
            l = helper(node.left);
            if(l<0){l = 0;}
        }
        if(node.right != null){
            r = helper(node.right);
            if(r<0){r = 0;}
        }
        ans = node.data;
        
        cans = ans + l + r;
        if(l>r){ans = ans + l ;}
        else{ans= ans + r;}
        if(cans>max){max = cans;}
        if(ans>max){max = ans;}
        return ans;
        
    }
}
