class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((n1,n2)->(n2-n1));
        for(int row=0; row<matrix.length; row++) {
            for(int col=0; col<matrix[row].length; col++) {
                minHeap.add(matrix[row][col]);
                if(minHeap.size()>k) {
                    minHeap.poll();
                }
            }
        }
        return minHeap.peek();
    }
}