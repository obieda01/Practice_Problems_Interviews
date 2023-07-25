class Solution:
    def subsetsWithDup(self, nums: List[int]) -> List[List[int]]:
        res = []
        nums.sort()
        def dfs(idx, subset):
            res.append(subset) 
            for i in range(idx, len(nums)):
                if i > idx and nums[i] == nums[i - 1]:
                    continue 
                dfs(i +1 , subset + [nums[i]])

        dfs(0,[])
        return res