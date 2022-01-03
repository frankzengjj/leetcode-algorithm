class Solution {
    public boolean validMountainArray(int[] A) {
        boolean increase = true, decrease = false;
        if (A.length == 0 || A.length < 3) return false;
        for (int i=1; i<A.length-1; i++) {
            if ((increase && A[i-1] >= A[i]) || (decrease && A[i-1] <= A[i])) {
                return false;
            } else {
                if (A[i-1] < A[i] && A[i] > A[i+1]) {
                    increase = false;
                    decrease = true;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}