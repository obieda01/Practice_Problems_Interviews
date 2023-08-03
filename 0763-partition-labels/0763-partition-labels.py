class Solution:
    def partitionLabels(self, s: str) -> List[int]:
        last = {}

        for i, c in enumerate(s):
            last[c] = i
        res = []
        end = 0
        size = 0
        for i, c in enumerate(s):
            end = max(end, last[c])
            size +=1
            if i == end:
                res.append(size)
                size =0
        return res