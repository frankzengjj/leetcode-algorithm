class Solution {
    public void rotate(int[][] matrix) {
        int n=matrix.length;
        int hi=0, bot=n-1;
        
        while(hi<bot) {
            int[] temp = matrix[hi];
            matrix[hi++] = matrix[bot];
            matrix[bot--]=temp;
        }
        
        for(int i=0; i<n; i++) {
            for(int j=i; j<n; j++) {
                if(i!=j) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
        }
        
    }
}