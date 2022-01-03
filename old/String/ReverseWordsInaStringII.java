class Solution {
    public void reverseWords(char[] s) {
        reverse(0, s.length-1, s);
        int i=0, j=0;
        while (j < s.length) {
            if (s[j] == ' ') {
                reverse(i, j-1, s);
                i=j+1;
            }
            j++;
        }
        reverse(i, s.length-1, s);
    }
    
    private void reverse(int i, int j, char[] s) {
        while (i <= j) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
    }
}