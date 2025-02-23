//https://www.geeksforgeeks.org/problems/next-larger-element-1587115620/1


class Solution {
    // Function to find the next greater element for each element of the array.
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> ans = new ArrayList<>(n);
        Stack<Integer> stack = new Stack<>();
        
        // Traverse from right to left
        for (int i = n - 1; i >= 0; i--) {
            // Remove elements from stack that are not greater than arr[i]
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }
            
            // If stack is empty, no greater element
            if (stack.isEmpty()) {
                ans.add(-1);
            } else {
                ans.add(stack.peek());
            }
            
            // Push current element to stack
            stack.push(arr[i]);
        }
        
        // Reverse the list to get the correct order
        Collections.reverse(ans);
        return ans;
    }
}