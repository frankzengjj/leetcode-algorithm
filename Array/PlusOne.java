class Solution {
    public int[] plusOne(int[] digits) {
        if(digits[digits.length-1]<9) {
            digits[digits.length-1]+=1;
        } else {
            int carry=1;
            for(int i=digits.length-1; i>=0; i--) {
                if(digits[i]+carry==10) {
                    digits[i]=0;
                    carry=1;
                } else {
                    digits[i]+=carry;
                    carry=0;
                }
            }
        }
        
        /**
        int sum=0;
        for(int j=0; j<digits.length; j++) {
            sum+=digits[j];
        }
        if(sum==0) {
            int[] res=new int[digits.length+1];
            res[0]=1;
            return res;
        }
            
        return digits;
        */
        
        if(digits[0]==0) {
            int[] res = new int[digits.length+1];
            res[0]=1;
            return res;
        }
        return digits;
    }
}