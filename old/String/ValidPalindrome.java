class Solution {
    public boolean isPalindrome(String s) {
        s=s.replaceAll("\\s","").replaceAll("[^a-zA-Z0-9 ]", "").toLowerCase();
        System.out.println(s);
        if(s.isEmpty()) {
            return true;
        }
        int left=0;
        int right=s.length()-1;
        while(left<=right) {
            if(s.charAt(left)!=s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}