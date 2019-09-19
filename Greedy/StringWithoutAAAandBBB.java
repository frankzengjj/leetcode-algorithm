class Solution {
    public String strWithout3a3b(int A, int B) {
        String res = "";
        char a = 'a', b = 'b';
        int i = A, j = B;
        if (i < j) {
            a = 'b';
            b = 'a';
            i = B;
            j = A;
        }
        
        while (i-- > 0) {
            res += a;
            if (i > j) {
                res += a;
                i--;
            }
            if (j-- > 0) {
                res += b;
            }
        }
        return res;
    }
}