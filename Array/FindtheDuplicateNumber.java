class Solution {
    public int findDuplicate(int[] nums) {
        
        //                s       
        //    3  1  3  4  2
        //    f                    
        int slow = nums[0];
		int fast = nums[nums[0]];
		do{
            slow = nums[slow];
			fast = nums[nums[fast]];
        } while(slow!=fast);

		fast = 0;
		while (fast != slow)
		{
			fast = nums[fast];
			slow = nums[slow];
            System.out.println("slow is: "+ slow + " fast is: " + fast);
		}
		return slow;
    }
}