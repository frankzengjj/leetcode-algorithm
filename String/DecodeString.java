class Solution {
    public String decodeString(String s) {
        Deque<Integer> countStack = new LinkedList<>();
        Deque<StringBuilder> strStack = new LinkedList<>();
        StringBuilder res = new StringBuilder();
        int k=0;
        
        for(char ch: s.toCharArray()) {
            if(Character.isDigit(ch)) {
                k=k*10+ch-'0';
            } else if(ch=='[') {
                countStack.push(k);
                strStack.push(res);
                k=0;
                res=new StringBuilder();
            } else if(ch==']') {
                StringBuilder temp = res;
                res = strStack.pop();
                for(int i=countStack.pop(); i>0; i--) res.append(temp);
            } else {
                res.append(ch);
            }
        }
        return res.toString();
    }
}