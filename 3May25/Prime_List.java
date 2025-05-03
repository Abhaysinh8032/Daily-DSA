//https://www.geeksforgeeks.org/problems/prime-list--170646/1


class Solution {
    Node primeList(Node head) {
        // code here
        //first try to get max no then we will create a array to of prime no
        Node node = head;
        int max = 0;
        while(node != null){
            if(node.val > max){
                max = node.val;
            }
            node = node.next;
        }
        // boolean array of are no prime prime--> false not prime---> true
        boolean[] isNotPrime = new boolean[max+1];
        isNotPrime[1] = true;
        for(int i = 2; i< isNotPrime.length;i++){
            if(!isNotPrime[i]){
                for(int j = i*2;j<isNotPrime.length;j = j+i){
                    isNotPrime[j] = true;
                }
            }
        }
        // again parse linked list for check 
        node = head;
        while(node != null){
            if(isNotPrime[node.val]){
                 node.val = findNearestPrimNO(node.val,isNotPrime);
            }
            
            node = node.next;
        }
        return head;
    
    }
    
    private int findNearestPrimNO(int tar, boolean[] isNotPrime){
        if(tar == 1){return 2;}
        int min = tar;
        int max = tar;
        while( isNotPrime[min] ){
            min--;
        }
        while(   isNotPrime[max] ){
            max++;
            if(max >= isNotPrime.length){
                //check for remaninng range max to tar + (tar-min)-(max -tar);
                int z = max;
                while(true){
                    if(traditionalPrimeCheck(z)){
                        max = z;
                        break;
                    }
                    z++;
                }
                
                break;
                
            }
        }
        if((tar-min)<(max-tar)){
            return min;
        }
        else if( (tar-min)==(max - tar)){
            return min;
        }
        else{
            return max;
        }
    }
    
    private boolean traditionalPrimeCheck(int z){
        for(int i = 2 ; (i*i)<=z;i++){
            if(z%i==0){
                return false;
            }
        }
        return true;
    }
}