class Solution {
    public int evalRPN(String[] tokens) {
        int a,b;
		Stack<Integer> S = new Stack<Integer>();
		for (String s : tokens) {
			if(s.equals("+")) {
				S.add(S.pop()+S.pop());
			}
			else if(s.equals("/")) {
				b = S.pop();
				a = S.pop();
				S.push(a / b);
			}
			else if(s.equals("*")) {
				S.push(S.pop() * S.pop());
			}
			else if(s.equals("-")) {
				b = S.pop();
				a = S.pop();
				S.push(a - b);
			}
			else {
				S.push(Integer.parseInt(s));
			}
		}	
		return S.pop();
    }
}