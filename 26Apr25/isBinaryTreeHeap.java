//https://www.geeksforgeeks.org/problems/is-binary-tree-heap/1


// User Function template for JAVA

/*
Node defined as
class Node{
    int data;
    Node left,right;
    Node(int d){
        data=d;
        left=right=null;
    }
}
*/


class Solution {
    boolean isHeap(Node tree) {
        // code here
       
        Queue<Node> que = new LinkedList<>();
        
        que.add(tree);
        
        while(!que.isEmpty()){
            Node node = que.poll(); //remove and get element from start/head
            //if we reached last level we have to pass check
            if(node == null){
                //if we get one null node then all other nodes should null 
                return isQueueNull(que);
            }
            
            Node left = node.left;
            Node  right = node.right;
            if(left != null && left.data> node.data){
                return false;
            }
            if(right != null && right.data> node.data){
                return false;
            }
            
            que.add(left);
            que.add(right);
        }
        return true;
    }
    
    private boolean isQueueNull(Queue<Node> que){
        while(!que.isEmpty()){
            Node node = que.poll();
            if(node != null){
                return false;
            }
        }
        return true;
    }
}