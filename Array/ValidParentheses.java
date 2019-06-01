class Solution {
    public boolean isValid(String s) {
        if(s.isEmpty()) return true;
        if(s.length()==1) return false;
        if(s.charAt(0)==')' || s.charAt(0)==']' || s.charAt(0)=='}') {
            return false;
        }
        
        Map<Character, Character> parentheses = new HashMap<>();
        parentheses.put(')','(');
        parentheses.put(']','[');
        parentheses.put('}','{');
        
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i)=='(' || s.charAt(i)=='[' || s.charAt(i)=='{') {
                stack.push(s.charAt(i));
            } else {
                if(stack.isEmpty()) {
                    return false;
                } else if(parentheses.get(s.charAt(i))==stack.peek()) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();

    }
}