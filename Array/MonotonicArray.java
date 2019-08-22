class Solution {
    public boolean isMonotonic(int[] A) {
        if (A.length == 0) return true;
        if (A[A.length-1] >= A[0]) {
            for (int i=1; i<A.length; i++) {
                if (A[i] < A[i-1]) return false;
            }
        } else {
            for (int j=1; j<A.length; j++) {
                if (A[j] > A[j-1]) return false;
            }
        }
        return true;
    }
}