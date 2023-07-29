class Solution:
    def rob(self, nums: List[int]) -> int:
        if not nums:
            return 0
        n = len(nums)
        robAmount = [None for i in range(n + 1)]
        robAmount[n -1] = nums[n -1]
        robAmount[n] = 0
        for i in range(n - 2, -1, -1):
            robAmount[i] = max(nums[i] + robAmount[i +2], robAmount[i + 1])
        return robAmount[0]