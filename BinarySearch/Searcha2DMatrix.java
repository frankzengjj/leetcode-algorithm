class Solution {
    // linear search: O(n+m)
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null||matrix.length==0) return false;
        int row=0, col=matrix[row].length-1;
        while(row<matrix.length && col>=0) {
            if(matrix[row][col]==target) {
                return true;
            } else if(matrix[row][col]>target) {
                col--;
            } else{
                row++;
            }
        }
        return false;
    }

    // Binary Search: O(logn+logm)
    public boolean binarySearchMatrix(int[][] matrix, int target) {
        if(matrix==null || matrix.length==0 || matrix[0].length==0) return false;
        int up=0, bot=matrix.length-1, mid=0;
        while(up<=bot) {
            mid=up+(bot-up)/2;
            if(matrix[mid][0]==target) {
                return true;
            } else if(matrix[mid][0] < target) {
                up=mid+1;
            } else {
                bot=mid-1;
            }
        }
        
        if(matrix[mid][0] > target){
            if(mid == 0){
                return false;
            }
            mid--;//mid-1
        }
        int row=mid;
        // int l=0, r=matrix[l].length-1, row=mid;
        // while(l<=r) {
        //     mid=l+(r-l)/2;
        //     if(matrix[row][mid] == target) {
        //         return true;
        //     } else if(matrix[row][mid] < target) {
        //         l=mid+1;
        //     } else {
        //         r=mid-1;
        //     }
        // }
        //System.out.println(Arrays.binarySearch(matrix[row], target));
        return Arrays.binarySearch(matrix[row], target)>=0;
    }

}