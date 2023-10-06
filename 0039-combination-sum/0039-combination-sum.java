class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        backtrack(candidates, res, list, target, 0);
        return res;
    }

    public void backtrack(int[]  candidates, List<List<Integer>> res, List<Integer> list, int target, int start){
        if(target == 0){
            res.add(new ArrayList(list));
            return;
        }else if(target < 0 || start >= candidates.length){
            return;
        }else{
            for(int i = start; i < candidates.length; i++){
                list.add(candidates[i]);
                backtrack(candidates, res, list, target - candidates[i], i);
                list.remove(list.get(list.size()-1));

            }
        }
    } 
}