class Solution:
    def partition(self, s: str) -> List[List[str]]:
        res = []
        
        def dfs(idx, subset):
            if idx >= len(s):
                res.append(subset[:])
            for i in range(idx, len(s)):
                if self.isPalandrom(s, idx, i):
                    dfs(i + 1, subset+[s[idx : i +1]])
            
        dfs(0, [])
        return res
    def isPalandrom(self, s, l , r):
        while l < r:
            if s[r] == s[l]:
                l += 1
                r -= 1
            else:
                return False
        return True