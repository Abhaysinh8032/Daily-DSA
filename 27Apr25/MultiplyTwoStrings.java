//https://www.geeksforgeeks.org/problems/multiply-two-strings/1



// User function Template for Java
class Solution {
    public String multiplyStrings(String s1, String s2) {
        boolean isNegative = false;
        
        if (s1.charAt(0) == '-') {
            isNegative = !isNegative;
            s1 = s1.substring(1);
        }
        if (s2.charAt(0) == '-') {
            isNegative = !isNegative;
            s2 = s2.substring(1);
        }
        
        s1 = removeLeadingZeros(s1);
        s2 = removeLeadingZeros(s2);
        
        if (s1.equals("0") || s2.equals("0")) {
            return "0";
        }
        
        String ans = multiplyProcessedString(s1, s2);
        
        if (isNegative) {
            ans = "-" + ans;
        }
        
        return ans;
    }
    
    private String removeLeadingZeros(String s) {
        int i = 0;
        while (i < s.length() && s.charAt(i) == '0') {
            i++;
        }
        if (i == s.length()) return "0"; // all zeros
        return s.substring(i);
    }
    
    private String multiplyProcessedString(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        int[] res = new int[n + m];
        
        for (int i = n - 1; i >= 0; i--) {
            int num1 = s1.charAt(i) - '0';
            for (int j = m - 1; j >= 0; j--) {
                int num2 = s2.charAt(j) - '0';
                int sum = res[i + j + 1] + num1 * num2;
                res[i + j + 1] = sum % 10;
                res[i + j] += sum / 10;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < res.length && res[i] == 0) {
            i++;
        }
        while (i < res.length) {
            sb.append(res[i++]);
        }
        
        return sb.toString();
    }
}
