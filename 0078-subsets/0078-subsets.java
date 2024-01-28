class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        backtrack(res, subset, 0, nums);
        return res;
    }
    public void backtrack(
        List<List<Integer>> res,
        List<Integer> subset,
        int start,
        int[] nums
    ){
        if(start >= nums.length){
            res.add(new ArrayList<>(subset));
        }else{
            subset.add(nums[start]);
            backtrack(res, subset, start + 1, nums);
            subset.remove(subset.size() - 1);
            backtrack(res, subset, start + 1, nums);

        }
    }
}