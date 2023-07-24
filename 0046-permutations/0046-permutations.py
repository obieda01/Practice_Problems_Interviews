class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        res = []
        if len(nums) == 1:
            return [nums.copy()]
        
        for num in nums:
            val = nums.pop(0)
            perms = self.permute(nums)
            for perm in perms:
                perm.append(val)
            res.extend(perms)
            nums.append(val)
        return res
                
