class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        backtrack(res, subset, 0, nums);
        return res;
    }
    public void backtrack(List<List<Integer>> res,
                        List<Integer> subset,
                        int start, 
                        int[] nums){
                            if(subset.size() == nums.length){
                                res.add(new ArrayList<>(subset));
                                return;
                            }else{
                                for(int i = 0; i < nums.length; i++){
                                    if(!subset.contains(nums[i])){
                                        subset.add(nums[i]);
                                        backtrack(res, subset, i + 1, nums);
                                        subset.remove(subset.size() - 1);
                                    }
                                }
                            }
                        }
}