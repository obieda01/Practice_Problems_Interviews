class Solution {
    public int findDuplicate(int[] nums) {
        while(nums[0]!=nums[nums[0]]){
            int num = nums[nums[0]];
            nums[nums[0]] =  nums[0];
            nums[0] = num;
        }
        return nums[0];
    }
}