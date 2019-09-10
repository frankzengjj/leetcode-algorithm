class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if (s.length() > 12 || s.length() < 4) return res;
        dfs(s, "", res, 0);
        return res;
    }
    
    private void dfs(String s, String ip, List<String> res, int section) {
        // base case
        if (section == 4) {
            if (s.length() == 0) {
                res.add(ip.substring(0, ip.length()-1));
                return;
            }
        }
        
        for (int i=1; i<=3; i++) {
            if (s.length() < i) continue;
            int val = Integer.parseInt(s.substring(0,i));
            // "023" => 23
            if (val > 255 || i != String.valueOf(val).length()) continue;
            dfs(s.substring(i), ip+val+".", res, section+1);
        }
    }
}