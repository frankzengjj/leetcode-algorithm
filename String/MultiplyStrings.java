class Solution {
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")) return "0";
        int[] products = new int[num1.length()+num2.length()];
        for(int i=num1.length()-1; i>=0; i--) {
            for(int j=num2.length()-1; j>=0; j--) {
                int mul=(num1.charAt(i)-'0') * (num2.charAt(j)-'0');
                products[i+j+1]+=mul;
            }
        }
        
        int carry=0;
        for(int k=products.length-1; k>=0; k--) {
            int temp=products[k];
            products[k]=(products[k]+carry)%10;
            carry=(temp+carry)/10;
        }
        
        // String res="";
        // for(int i=0; i<products.length; i++) {
        //     if(i==0 && products[i]==0) continue;
        //     res+=String.valueOf(products[i]);
        // }
        StringBuilder sb = new StringBuilder();
        for (int num : products) sb.append(num);
        if (sb.charAt(0) == '0') sb.deleteCharAt(0);
        return sb.toString();
    }
}