class Solution:
    def singleNumber(self, nums: List[int]) -> int:
        """
        010            0^0 = 1
        010  => xor     0^1 = 0
        001
        001

        1 ^ 0 = 0
        """
        res = 0
        for num in nums:
            res = res ^ num
        return res