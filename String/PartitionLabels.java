class Solution {
    public List<Integer> partitionLabels(String S) {
        List<Integer> res = new LinkedList<>();
        int[] map = new int[26];
        for (int i=0; i<S.length(); i++) {
            map[S.charAt(i)-'a'] = i;
        }
        
        int start=0, end=0;
        for (int j=0; j<S.length(); j++) {
            end = Math.max(end, map[S.charAt(j)-'a']);
            if (j==end) {
                res.add(end-start+1);
                start = end + 1;
            }
        }
        return res;
    }
}