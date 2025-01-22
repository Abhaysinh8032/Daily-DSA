//Add Number Linked Lists
//https://www.geeksforgeeks.org/problems/add-two-numbers-represented-by-linked-lists/1

/* node for linked list

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

*/

class Solution {
    static Node addTwoLists(Node num1, Node num2) {
        // code here
        Node node = num1;
        Node prev  = null;

        //the leading zero problem is solved
        while(node!= null && node.data == 0){
        	prev = node;
        	node = node.next;
        }
        num1 = node;
        if(prev != null)prev.next = null;



        node = num2;
        prev = null;
        while(node!= null && node.data == 0){
        	prev = node;
        	node = node.next;
        }
        num2 = node;
        if(prev != null)prev.next = null;
        if(num1 == null && num2 == null){return null;}
        if(num1 == null && num2 != null){return num2;}
        if(num1 != null && num2 == null){return num1;}
        
         num1 = reverse(num1);
        //  return num1;
         num2   = reverse(num2);
        //  return num2;
        int carry = 0;
        Node ans  = null;
        while(num1 != null && num2 != null){
        	int temp = num1.data + num2.data + carry;
        	Node t = new Node(temp%10);
        	t.next = ans;
        	ans = t;
        	carry = temp /10;
        	num1 = num1.next;
        	num2 = num2.next;
        }
        while(num1 != null){
            if(carry != 0){
                int temp = num1.data + carry;
                Node t = new Node(temp%10);
                t.next = ans;
                ans = t;
                carry = temp/10;
                num1 = num1.next;
                    
                
            }
            else{
                Node t = num1.next;
                num1.next = ans;
                ans = num1;
                num1 = t;
            }
        }
        while(num2 != null){
            if(carry != 0){
                int temp = num2.data + carry;
                Node t = new Node(temp%10);
                t.next = ans;
                ans = t;
                carry = temp/10;
                num2 = num2.next;
                    
                
            }
            else{
                
                Node t = num2.next;
                num2.next = ans;
                ans = num2;
                num2 = t;
            }
        }
        if(carry != 0){
        	Node t = new Node(carry);
        	t.next = ans;
        	ans = t;
        }
        return ans;
    }
    static Node reverse(Node node){
        if(node == null){return node;}
        Node prev = null;
        if(node.next == null){return null;}
        Node nex = node.next;
        
        while(node != null){
            node.next = prev;
            
            prev = node;
            node = nex;
            if(nex!= null){
                nex = nex.next;
            }
        }
        return prev;
    }
}






