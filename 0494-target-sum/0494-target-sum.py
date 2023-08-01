class Solution:
    def findTargetSumWays(self, nums: List[int], target: int) -> int:
        db = {} #(index, totalSoFar)

        def dfs(idx, sums):
            if idx == len(nums):
                if sums == target:
                    return 1
                else: 
                    return 0
            if (idx, sums) in db:
                return db[(idx, sums)]
            db[(idx, sums)] = dfs(idx + 1, sums + nums[idx]) +dfs(idx + 1, sums - nums[idx])
            
            return db[(idx, sums)]
        return dfs(0,0)
