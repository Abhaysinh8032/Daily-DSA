//submit code 2 times it will get accepted
//https://www.geeksforgeeks.org/problems/rotate-a-linked-list/1


class Solution {
    public Node rotate(Node head, int k) {
        // add code here
       if (head == null || head.next == null || k == 0) {
            return head;
        } 
        Node end = null; 
        Node nhead = null;
        Node nend = null;
        
        Node node = head;
        int l = 1;
        while(node.next != null){
            node = node.next;
            l++;
        }
        nend = node;
        k = k%l;
        if(k == 0){return head;}
        node = head;
        while(k>1){
            node = node.next;
            k--;
        }
        end = node;
        nhead = node.next;
        
        //detaching list into two list
        end.next = null;
        //attaching two part two form desire list
        nend.next = head;
        return nhead;
        
        
    }
}