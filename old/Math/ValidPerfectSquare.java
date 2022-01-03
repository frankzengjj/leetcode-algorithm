class Solution {
    public boolean isPerfectSquare(int x) {
        if(x==1 || x==0) return true;
        //if(x%2!=0) return false;
        
        int l = 1;
        int r = x;
        while (l <= r) {
          int m = l + (r - l) / 2;
          if (m > x / m) {
            r = m - 1;
          } else {
            l = m + 1;
          }
        }
        
        return r*r==x;
    }
}