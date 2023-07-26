class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        res = []
        if digits == "":
            return []
        digitToChar = {
            "2": "abc",
            "3": "def",
            "4": "ghi",
            "5": "jkl",
            "6": "mno",
            "7": "qprs",
            "8": "tuv",
            "9": "wxyz",
        }
        def dfs(idx, subset):
            if len(subset) == len(digits):
                res.append(subset)
            for i in range(idx, len(digits)):
                for c in digitToChar[digits[i]]:
                    dfs(i + 1, subset+c)
        dfs(0, "")
        return res