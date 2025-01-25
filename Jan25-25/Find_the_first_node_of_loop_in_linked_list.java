//https://www.geeksforgeeks.org/problems/find-the-first-node-of-loop-in-linked-list--170645/1

class Solution {
    public static Node findFirstNode(Node head) {
        // code here
        Node f = head;
        Node s = head;
        
        while(s != f){
            s = s.next;
            f = f.next;
            if(f== null){
                return new Node(-1);
               
            }
            else{
                 f = f.next;
            }
        }
        
        s = head;
        f = head;
        HashSet<Node> set=new HashSet();    
        while(!set.contains(f) && f!= null){
            set.add(s);
            s = s.next;
            f = f.next;
            if(set.contains(f) ){
                return f;
            }
            if(f== null){
                return new Node(-1);
            }
            f  = f.next;
            
        }
       
        return f;
        
    }
}