//https://www.geeksforgeeks.org/problems/detect-loop-in-linked-list/1


//use fast and slow pointer
class Solution {
    // Function to check if the linked list has a loop.
    public static boolean detectLoop(Node head) {
        // Add code here
        Node f = head.next;
        Node s = head;
        while(f!= null){
            if(f==s){return true;}
            f = f.next;
            if(f!= null){f = f.next;}
            s = s.next;
        }
        return false;
    }
}