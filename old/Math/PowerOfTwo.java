class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n==1) return true;
        if(n%2!=0) return false;
        
        while(n>2) {
            n/=2;
            if(n%2!=0) {
                return false;
            }
        }
        return n==2;
    }
}