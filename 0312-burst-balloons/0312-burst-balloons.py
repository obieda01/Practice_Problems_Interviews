class Solution:
    def maxCoins(self, nums: List[int]) -> int:
        db = {}
        nums = [1]+nums+[1]

        def dfs(l, r):
            if l > r:
                return 0
            if (l,r) in db:
                return db[(l, r)]

            db[(l, r)] = 0

            for i in range(l, r + 1):
                coins = nums[l-1] * nums[i] * nums[r+1]
                coins += dfs(l, i -1) + dfs(i + 1, r)
                db[(l, r)] = max(db[(l, r)], coins)
            return db[(l, r)]
        return dfs(1, len(nums)-2)