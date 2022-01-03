class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int left=0, right=n-1, up=0, down=n-1, val=1;
        while (true) {
            for(int j=left; j<=right; j++) res[up][j]=val++;
            if(++up>down) break;
            for(int j=up; j<=down; j++) res[j][right]=val++;
            if(--right<left) break;
            for(int j=right; j>=left; j--) res[down][j]=val++;
            if(--down<up) break;
            for(int j=down; j>=up; j--) res[j][left]=val++;
            if(++left>right) break;
        }
        return res;
    }
}