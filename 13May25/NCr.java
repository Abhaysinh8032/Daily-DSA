//https://www.geeksforgeeks.org/problems/ncr1019/1

class Solution {
    public int nCr(int n, int r) {
        // code here
        if(r>n ){
            return 0;
        }
        
        
        int denominator = r;
        if((n-r)>0){
            denominator = Math.min(r,n-r);
        }
        
        if(denominator == 0){
            return 1;
        }
        // int ans = (int) (fact(n,denominator)/fact(denominator,denominator));
        int ans = binomialCoefficien(n,denominator);
        return ans;
    }
    
    private long fact(int n, int c){
        if(n==0){
            return 1;
        }
         long ans = 1;
        while(c>0 && n>0){
            ans = n*ans;
            c--;
            n--;
        }
        return ans;
    }
    
    private int binomialCoefficien(int n, int r){
        if(n==0){
            return 1;
        }
        long ans = 1;
        // int c = r;
        // while(c>0 && n>0 && r>0){
        //     ans = ans*n;
        //     n--;
        //     ans = ans/r;
        //     r--;
        //     c--;
        // }
        for(int i = 1; i<=r;i++){
            ans = ans * n;
            n--;
            ans = ans/i;
        }
        return (int) ans;
    }
}