https://www.geeksforgeeks.org/problems/decode-the-pattern1138/1

class Solution {
    public String countAndSay(int n) {
        // code here
        String num = "1";
        for(int i = 1; i<n;i++){
            int j = 0;
            String temp = "";
            while(j<num.length()){
                char c = num.charAt(j);
                j++;
                int count = 1;
                while(j<num.length() && num.charAt(j)==c){
                    count++;
                    j++;
                }
                temp = temp+ count+""+ c;
            }
            num = temp;
        }
        return num;
    }
}
