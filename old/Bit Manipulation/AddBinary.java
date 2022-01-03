class Solution {
    public String addBinary(String a, String b) {
        int len1 = a.length(); 
        int len2 = b.length(); 
        if (len1 < len2) { 
            for (int i = 0 ; i < len2 - len1 ; i++) {
                a = '0' + a;
            }  
        } else if (len1 > len2) { 
            for (int i = 0 ; i < len1 - len2 ; i++) {
                b = '0' + b;
            }
        } 
        
        int length=Math.max(len1, len2);
        String result="";
        int carry=0;
        for(int i=length-1; i>=0; i--) {
            
            int firstBit = a.charAt(i) - '0'; 
            int secondBit = b.charAt(i) - '0'; 
            
            int sum = (firstBit ^ secondBit ^ carry)+'0';
            result = (char)sum + result;
            carry = (firstBit & secondBit) | (secondBit & carry) | (firstBit & carry); 
        }
        if(carry==1) {
            result = '1' + result;
        }
        return result;
    }
}