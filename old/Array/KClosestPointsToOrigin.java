class Point {
    public int x;
    public int y;
        
    public Point(int x, int y) {
        this.x=x;
        this.y=y;
    }
        
    public int getDist() {
        return this.x*this.x + this.y*this.y;
    }
}

class Solution {
    
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<Point> maxHeap = 
            new PriorityQueue<>((p1, p2)->(p2.getDist() - p1.getDist()));
        
        for (int i=0; i<K; i++) {
            maxHeap.add(new Point(points[i][0], points[i][1]));
        }
        
        for (int j=K; j<points.length; j++) {
            Point pt = new Point(points[j][0], points[j][1]);
            if (pt.getDist() < maxHeap.peek().getDist()) {
                maxHeap.poll();
                maxHeap.add(pt);
            }
        }
        int[][] res = new int[maxHeap.size()][2];
        for (int k=0; k<res.length; k++) {
            Point pt = maxHeap.poll();
            res[k][0]=pt.x;
            res[k][1]=pt.y;
        }
        return res;
    }
}