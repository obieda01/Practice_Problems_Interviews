class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        res = []
        def dfs(i, total, subset):
            
            if total == target  :
                res.append(subset[:])
                return
            if i >= len(candidates) or total > target:
                return
            subset.append(candidates[i])
            dfs(i, total + candidates[i], subset)
            subset.pop()
            dfs(i + 1, total, subset)
        dfs(0, 0, [])
        return res
                
        