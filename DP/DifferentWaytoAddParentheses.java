import java.util.*;
class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        return ways(input, new HashMap<String, List<Integer>>());
    }
    
    private List<Integer> ways(String input, Map<String, List<Integer>> memo) {
        if(memo.containsKey(input)) {
            return memo.get(input);
        }
        
        List<Integer> res = new ArrayList<>();
        for(int i=0; i<input.length(); i++) {
            char op = input.charAt(i);
            if(op=='+' || op=='-' || op=='*') {
                List<Integer> left = ways(input.substring(0,i), memo);
                List<Integer> right = ways(input.substring(i+1), memo);
                for(Integer l: left) {
                    for(Integer r: right) {
                        int curRes=0;
                        switch(op){
                            case '+': 
                                curRes=l+r;
                                break;
                            case '-':
                                curRes=l-r;
                                break;
                            case '*':
                                curRes=l*r;
                                break;
                        }
                        res.add(curRes);
                    }
                }
            }
        }
        if(res.size()==0) {
            res.add(Integer.valueOf(input));
        }
        memo.put(input, res);
        return res;
    }
}