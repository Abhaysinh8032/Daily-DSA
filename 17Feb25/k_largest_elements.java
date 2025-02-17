//https://www.geeksforgeeks.org/problems/k-largest-elements4206/1

class Solution {
    public ArrayList<Integer> kLargest(int[] arr, int k) {
        // Your code here
        
        ArrayList<Integer> ans = new ArrayList<Integer>();
        if(arr.length < 1 && k<1){
            return null;
        }
        if(arr.length == 1 && k==1){
            ans.add(arr[0]);
            return ans;
        }
        if(k==1){
            int max = arr[0];
            for(int i = 0; i<arr.length;i++){
                if(arr[i]>max){
                    max = arr[i];
                }
            }
            ans.add(max);
            return ans;
        }
        
        Arrays.sort(arr);
        //sort array in ascending order
        
        //reverse array so it become descending
        int j  = arr.length-1;
        for(int i = 0; i<arr.length/2;i++){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            j--;
        }
        
        
        //add first k elements in ans array
        for(int i  = 0; i<k;i++){
            ans.add(arr[i]);
        }
        return ans;
    }
}
