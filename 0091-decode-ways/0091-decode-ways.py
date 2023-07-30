class Solution:
    def numDecodings(self, s: str) -> int:
        db = {len(s):1}
        for i in range(len(s) -1, -1, -1):
            if s[i] == "0":
                db[i] = 0
            else:
                db[i] = db[i + 1]

            if (i + 1 < len(s) and(
                s[i] == "1" or s[i] =="2" and s[i+1] in "0123456"
            )):
                db[i] += db[i+2]
        return db[0]
        