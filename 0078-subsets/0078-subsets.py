class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        res = []
        subRes = []
        def dfs(i : int):
            if i >= len(nums):
                res.append(subRes.copy())
                return
            subRes.append(nums[i])
            dfs(i + 1)
            subRes.pop()
            dfs(i + 1)
        dfs(0)
        return res

