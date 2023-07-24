class Solution:
    def subsetsWithDup(self, nums: List[int]) -> List[List[int]]:
        res = []
        subset = []
        nums.sort()
        def backtrack(subset, i):
            if i == len(nums):
                res.append(subset.copy())
                return
            subset.append(nums[i])
            backtrack(subset, i + 1)
            subset.pop()
            while i + 1 < len(nums) and nums[i] == nums[i + 1]:
                i += 1
            backtrack(subset, i + 1)

        backtrack(subset, 0)

        return res