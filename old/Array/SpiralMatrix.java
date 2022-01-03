class Solution {
    public List<Integer> spiralOrder(int[][] a) {
        List<Integer> res = new ArrayList<>();
        if(a==null || a.length==0) return res;
        int i, k = 0, l = 0, m=a.length, n=a[0].length;
        
        while (k < m && l < n) {
            // Print the first row from the remaining rows 
            for (i = l; i < n; ++i) { 
                res.add(a[k][i]); 
            } 
            k++; 
  
            // Print the last column from the remaining columns 
            for (i = k; i < m; ++i) { 
                res.add(a[i][n - 1]); 
            } 
            n--; 
  
            // Print the last row from the remaining rows */ 
            if (k < m) { 
                for (i = n - 1; i >= l; --i) { 
                    res.add(a[m - 1][i]); 
                } 
                m--; 
            } 
  
            // Print the first column from the remaining columns */ 
            if (l < n) { 
                for (i = m - 1; i >= k; --i) { 
                    res.add(a[i][l]); 
                } 
                l++; 
            } 
        } 
        return res;
    }
}