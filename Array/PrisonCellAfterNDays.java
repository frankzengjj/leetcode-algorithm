class Solution {
    public int[] prisonAfterNDays(int[] cells, int N) {
        for (N=(N-1)%14+1; N>0; N--) {
            int[] cells2 = new int[8];
            for (int j=1; j<7; j++) {
                cells2[j] = cells[j-1]==cells[j+1] ? 1 : 0;
            }
            cells = cells2;
        }
        return cells;
    }
}