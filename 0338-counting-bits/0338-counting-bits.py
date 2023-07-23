class Solution:
    def countBits(self, n: int) -> List[int]:
        counter = [0]
        for i in range(1, n + 1):
            c = i % 2
            i = i >> 1
            counter.append(counter[i] + c)
        return counter 