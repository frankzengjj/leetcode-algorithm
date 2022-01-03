class Solution {
    String[] d = new String[]{" ", 
                              "", 
                              "abc", 
                              "def",
                              "ghi",
                              "jkl",
                              "mno",
                              "pqrs",
                              "tuv",
                              "wxyz"}; 
  private List<String> res = new ArrayList<>();
  public List<String> letterCombinations(String digits) {
      if(digits.length()==0) {
          return res;
      }
      char[] combination = new char[digits.length()];
      dfs(d, digits, 0, combination);
      return res;
  }
  
  private void dfs(String[] d, String digits, int pos, char[] combination) {
      if(pos==digits.length()) {
          res.add(new String(combination));
          return;
      }
      
      String s = d[Character.getNumericValue(digits.charAt(pos))];
      for(int i=0; i<s.length(); i++) {
          combination[pos]=s.charAt(i);
          dfs(d, digits, pos+1, combination);
          combination[combination.length-1]=0;
      }
  }
}