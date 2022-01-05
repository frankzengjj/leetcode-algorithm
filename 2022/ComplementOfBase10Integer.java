class Solution {
    public int bitwiseComplement(int n) {
        // l is a length of N in binary representation
        int l = (int)( Math.log(N) / Math.log(2) ) + 1;
        // bitmask has the same length as num and contains only ones 1...1
        int bitmask = (1 << l) - 1;
        // flip all bits
        return bitmask ^ N;
    }
}