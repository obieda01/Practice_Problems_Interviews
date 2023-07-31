class Solution:
    def longestCommonSubsequence(self, text1: str, text2: str) -> int:
        db = [[0 for i in range(len(text2) + 1)] for j in range(len(text1) + 1)]

        for i in range(len(text1) - 1, -1, -1):
            for j in range (len(text2) - 1, -1, -1):
                if text1[i] == text2[j]:
                    db[i][j] = 1 + db[i + 1][j + 1]
                else:
                    db[i][j] = max(db[i][j+1], db[i + 1][j])
        return db[0][0]