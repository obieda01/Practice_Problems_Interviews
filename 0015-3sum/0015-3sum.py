class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        res = []
        nums.sort()
        for i, a in enumerate(nums):
            l = i + 1
            r = len(nums) - 1
            if i > 0 and a == nums[i - 1]:
                continue  
            while l < r:
                val = a + nums[l] + nums[r]
                if val == 0:
                    res.append([a, nums[l], nums[r]])
                    l += 1
                    r -= 1
                    while (l < r and nums[l] == nums[l - 1]):
                        l +=1
                elif val < 0 :
                    l += 1
                else:
                    r -= 1
        return res