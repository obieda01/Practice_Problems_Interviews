class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        res = []
        def dfs(idx, subset):
            res.append(subset[:])
            for i in range(idx, len(nums)):
                dfs(i + 1, subset+[nums[i]])
        dfs(0, [])
        return res