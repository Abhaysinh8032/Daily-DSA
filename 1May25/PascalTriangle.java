//Pascal Triangle
//https://www.geeksforgeeks.org/problems/pascal-triangle0652/1

class Solution {

    ArrayList<Integer> nthRowOfPascalTriangle(int n) {
        // code here
        ArrayList<Integer> ans = new ArrayList<Integer>();
        
        ans.add(1);
        
        int i = 1;
        while(i<n){
            ArrayList<Integer> temp = new ArrayList<Integer>();
            temp.add(1);
            for(int j = 1; j<ans.size();j++){
                temp.add(ans.get(j)+ans.get(j-1));
            }
             temp.add(1);
            i++;
            ans = temp;
        }
        return ans;
    }
}