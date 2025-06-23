class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        db = [False]*(len(s)+1)
        db[len(s)] = True
        for i in range(len(s) - 1, -1, -1):
            for w in wordDict:
                if(i + len(w)) <= len(s) and s[i:i+len(w)] == w:
                    db[i] = db[i + len(w)]
                if db[i]:
                    break
        return db[0]