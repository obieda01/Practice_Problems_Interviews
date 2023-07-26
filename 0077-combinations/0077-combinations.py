class Solution:
    def combine(self, n: int, k: int) -> List[List[int]]:
        res = []
        
        def dfs(idx, subset):
            if len(subset) == k:
                res.append(subset[:])
            for i in range(idx, n + 1):
                dfs(i + 1, subset + [i])
        dfs(1, [])
        return res
            
        