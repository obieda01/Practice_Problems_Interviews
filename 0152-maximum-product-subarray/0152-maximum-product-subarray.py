class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        res = nums[0]
        curMax, curMin = 1, 1
        for i in range(len(nums)):
            n = nums[i]
            temp = curMax
            curMax = max(n, n * curMax, n * curMin)
            curMin = min(n, n * temp, n * curMin)
            res = max(res, curMax)
        return res