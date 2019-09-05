class Solution {
    public int compress(char[] chars) {
        int i=0, ans=0;
        while (i < chars.length) {
            char cur = chars[i];
            int count = 0;
            while (i < chars.length && cur == chars[i]) {
                i++;
                count++;
            }
            chars[ans++] = cur;
            if (count != 1) {
                for (char num: String.valueOf(count).toCharArray()) {
                    chars[ans++] = num;
                }
            }
        }
        return ans;
    }
}