class Solution {
    List<String> res;
    int[] nums;
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        res = new LinkedList();
        this.nums = nums;
        int len = nums.length;
        long llower = lower, lupper = upper;

        for(long n : nums){
            if(llower < n) addRange(llower, n - 1);
            llower = n + 1;
        }
        if(llower <= lupper) addRange(llower, lupper);
        return res;
    }

    public void addRange(long l, long r){
        if(l == r) res.add(String.valueOf(l));
        else res.add(String.valueOf(l) + "->" + String.valueOf(r));
    }
}