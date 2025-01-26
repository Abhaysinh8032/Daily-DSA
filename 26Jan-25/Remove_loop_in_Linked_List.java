//https://www.geeksforgeeks.org/problems/remove-loop-in-linked-list/1
//Remove loop in Linked List

//similar as Find first Node in Loop 24 Jan2025 
//just need make last node.next = null;


class Solution {
    // Function to remove a loop in the linked list.
    public static void removeLoop(Node head) {
        // code here
         Node f = head;
        Node s = head;
        
        while(s != f){
            s = s.next;
            f = f.next;
            if(f== null){
                return ;
               
            }
            else{
                 f = f.next;
            }
        }
        
        s = head;
        f = head;
        HashSet<Node> set=new HashSet();    
        while(!set.contains(f.next) && f.next!= null){
            set.add(s);
            s = s.next;
            f = f.next;
            if(set.contains(f.next) ){
                f.next = null;
                return ;
            }
            if(f.next== null){
                return ;
            }
            f  = f.next;
            
        }
       
        f.next = null;
        
    }
}
