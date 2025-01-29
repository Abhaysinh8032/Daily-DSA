//https://www.geeksforgeeks.org/problems/powx-n/1

//Implement Pow

class Solution {
    double power(double b, int e) {
        // code here
        if(b==0){
            return 0d;
            //if number is 0 then any power of it will be 0
        }
        if(e==0){
            return 1d;//if power of any number is 0 then ans is 1
        }
        double ans = 0 ;
        if(e>0){
            ans = hpower(b,e);
        }
        else{
            //if e is negative make inverse
            e = -e;
            ans = hpower(b,e);
            ans = 1/ans;
        }
        // ans = hpower(b,e);
        return ans;
        
    }
    
    double hpower(double b, int e){
        int c = 1;
        double ans = b;
        
        while(c*2<=e){
            ans = ans * ans;
            c *=2;
        }
        if(c==e){
            return ans;
        }
        else{
            ans =  ans*hpower(b,e-c);
        }
        return ans;
        
    }
}