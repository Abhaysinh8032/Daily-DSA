https://www.geeksforgeeks.org/problems/clone-a-linked-list-with-next-and-random-pointer/1

class Solution {
    public Node cloneLinkedList(Node head) {
        // code here
        if (head == null) {
            return null;
        }
        //add new node to orignal 
        
        Node node = head ;//pointer on orignal list
        while(node != null){
            Node newNode = new Node(node.data);
            newNode.next = node.next;
            node.next  = newNode;
            node = newNode.next;
        }
        
        
        //to assign random according to sequence
        node = head;
        while(node != null){
            if(node.random != null){node.next.random = node.random.next;}
            node = node.next.next;
        }
        
        //separate the list orignal and fnew 
        
        node = head;
        Node ans = head.next;
        Node tnode = ans;
        while( tnode.next != null){
            node.next = node.next.next;
            node = node.next;
            tnode.next = tnode.next.next;
            tnode = tnode.next;
            
        }
        node.next = null;
        tnode.next = null;
        return ans;
        
    }
}