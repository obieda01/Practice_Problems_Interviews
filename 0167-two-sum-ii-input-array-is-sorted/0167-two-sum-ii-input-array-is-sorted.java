class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0, r = numbers.length -1;
        while(numbers[r] + numbers[l] != target){
            if(numbers[r] + numbers[l] < target) l++;
            else r--;
        }
        return new int[]{l+1, r+1};
    }
}