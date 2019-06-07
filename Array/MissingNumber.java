class Solution {
    public int missingNumber(int[] nums) {
        Set<Integer> numSet = new HashSet<Integer>();
        for (int num : nums) numSet.add(num);
        for (int number = 0; number < nums.length + 1; number++) {
            if (!numSet.contains(number)) {
                return number;
            }
        }
        return -1;
    }
}