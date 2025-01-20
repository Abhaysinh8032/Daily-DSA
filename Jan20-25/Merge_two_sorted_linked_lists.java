// https://www.geeksforgeeks.org/problems/merge-two-sorted-linked-lists/1
//Merge two sorted linked lists
/*Given the head of two sorted linked lists consisting of nodes respectively. The task is to merge both lists and return the head of the sorted merged list.*/


class Solution {
    Node sortedMerge(Node head1, Node head2) {
        // code here
        if(head1 == null && head2 == null){return null;}
        if(head1 == null && head2 != null){return head2;}
        if(head2 == null && head1 != null){return head1;}
        
        Node ans;
        if(head1.data <head2.data){
                
                ans = head1;
                head1 = head1.next;
            }
        else{
               
                ans = head2;
                head2 = head2.next;
            }
        Node anshead = ans;
        
        while(head1 != null && head2!= null){
            if(head1.data <head2.data){
                ans.next = head1;
                ans = head1;
                head1 = head1.next;
            }
            else{
                ans.next = head2;
                ans = head2;
                head2 = head2.next;
            }
        }
        
        if(head1 != null){
            ans.next = head1;
        }
        if(head2 != null){
            ans.next = head2;
        }
        return anshead;
    }
}
