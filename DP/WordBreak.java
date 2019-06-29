class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<String>(wordDict);
        Map<String, Boolean> memo = new HashMap<>();
        return wordBreak(s, set, memo);
    }
    
    private boolean wordBreak(String s, Set<String> set, Map<String, Boolean> memo) {
        if(memo.containsKey(s)) {
            return memo.get(s);
        }
        if(set.contains(s)) {
            memo.put(s, true);
            return true;
        }
        
        for(int i=0; i<s.length(); i++) {
            if(set.contains(s.substring(0,i)) && wordBreak(s.substring(i, s.length()), set, memo)) {
                memo.put(s, true);
                return true;
            }
        }
        
        memo.put(s, false);
        return false;
        
        
    }
}