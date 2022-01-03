class Solution {
    public int numFriendRequests(int[] ages) {
        int[] count = new int[121];
        for (int age: ages) {
            count[age]++;
        }
        
        int res = 0;
        for (int A=1; A <= 120; A++) {
            for (int B=A/2+8; B<=A; B++) {
                if (B < A) {
                    res += count[B] * count[A];
                } else if (B==A) {
                    res += count[A] * (count[A] - 1);
                }
            }
        }
        return res;
    }
}