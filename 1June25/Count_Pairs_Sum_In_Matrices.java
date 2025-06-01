//https://www.geeksforgeeks.org/problems/count-pairs-sum-in-matrices4332/1



class Solution {
    int countPairs(int[][] mat1, int[][] mat2, int x) {
        // code here
        int n = mat1.length;
        Integer r1 = 0;
        Integer r2 = n-1;
        Integer c1 = 0;
        Integer c2 = n-1;
        Integer p1 = mat1[0][0];
        Integer p2 = mat2[n-1][n-1];
        int sum = p1+p2;
        int count = 0;
        while(r1<n && r2>=0){
            sum = p1+p2;
            if(sum == x){
                count++;
            //move bothe p1forward  and p2backward
                                            if(r1>=n || c1 >= n){
                                        return count;
                                    }
                                    if(c1 == n-1){
                                        if(  r1 >= n-1){
                                              r1++;
                                            return count;
                                        }
                                        else if( r1 < n){
                                            r1++;
                                            c1 = 0;
                                            p1 = mat1[r1][c1];
                                            // return;
                                        }
                                      
                                    }
                                    else{
                                        c1++;
                                        p1 = mat1[r1][c1];
                                        // return;
                                    }
                //mvoe p2 backward
                                                if(r2<0 || c2 < 0){
                                            return count;
                                        }
                                        if(c2 == 0){
                                            if(  r2 <= 0){
                                                  r2--;
                                                return count;
                                            }
                                            else if( r2 > 0){
                                                r2--;
                                                c2 = n-1;
                                                p2 = mat2[r2][c2];
                                                // return;
                                            }
                                          
                                        }
                                        else{
                                            c2--;
                                            p2 = mat2[r2][c2];
                                            // return;
                                        }
            }
            else if(sum > x){
                //move p2 backward
                                                    if(r2<0 || c2 < 0){
                                                return count;
                                            }
                                            if(c2 == 0){
                                                if(  r2 <= 0){
                                                      r2--;
                                                    return count;
                                                }
                                                else if( r2 > 0){
                                                    r2--;
                                                    c2 = n-1;
                                                    p2 = mat2[r2][c2];
                                                    // return;
                                                }
                                              
                                            }
                                            else{
                                                c2--;
                                                p2 = mat2[r2][c2];
                                                // return;
                                            }
            }
            else{
                //move p1 forward
                                    if(r1>=n || c1 >= n){
                                return count;
                            }
                            if(c1 == n-1){
                                if(  r1 >= n-1){
                                      r1++;
                                    return count;
                                }
                                else if( r1 < n){
                                    r1++;
                                    c1 = 0;
                                    p1 = mat1[r1][c1];
                                    // return;
                                }
                              
                            }
                            else{
                                c1++;
                                p1 = mat1[r1][c1];
                                // return;
                            }
            }
        }
        return count;
    }
    
    private void moveMat1(Integer r1, Integer c1 , Integer p1 ,int[][] mat1){
        //pushForward
        Integer n = mat1.length;
        if(r1>=n || c1 >= n){
            return;
        }
        if(c1 == n-1){
            if(  r1 >= n-1){
                  r1++;
                return;
            }
            else if( r1 < n){
                r1++;
                c1 = 0;
                p1 = mat1[r1][c1];
                return;
            }
          
        }
        else{
            c1++;
            p1 = mat1[r1][c1];
            return;
        }
        
    }
    private void moveMat2(Integer r2, Integer c2 , Integer p2 , int[][] mat2){
        //pushBackward
        Integer n = mat2.length;
        if(r2<0 || c2 < 0){
            return;
        }
        if(c2 == 0){
            if(  r2 <= 0){
                  r2--;
                return;
            }
            else if( r2 > 0){
                r2--;
                c2 = n-1;
                p2 = mat2[r2][c2];
                return;
            }
          
        }
        else{
            c2--;
            p2 = mat2[r2][c2];
            return;
        }
        
    }
}