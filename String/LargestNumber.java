class Solution {
    public String largestNumber(int[] nums) {
        Comparator<String> largestNumComparator = new Comparator<String>() {
            @Override
            public int compare(String num1, String num2){
                String o1 = num1 + num2;
                String o2 = num2 + num1;
                return o2.compareTo(o1);
            }
        };
        
        String[] numArr = new String[nums.length];
        for (int i=0; i<nums.length; i++) numArr[i] = String.valueOf(nums[i]);
        Arrays.sort(numArr, largestNumComparator);
        if (numArr[0].equals("0")) return "0";
        StringBuilder sb = new StringBuilder();
        for (String num: numArr) sb.append(num);
        return sb.toString();
    }
}