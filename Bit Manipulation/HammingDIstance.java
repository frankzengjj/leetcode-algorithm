class Solution {
    public int hammingDistance(int x, int y) {
        int mask = 1, res = 0;
        for (int i=0; i < 31; i++) {
            int count = 0;
            System.out.println(x&mask);
            if ((x & mask) != 0) count++;
            if ((y & mask) != 0) count++;
            mask <<= 1;
            res += (2 - count) * count;
        }
        return res;
    }
}