class Solution:
    def canCompleteCircuit(self, gas: List[int], cost: List[int]) -> int:
        total = 0
        curTotal = 0
        next = 0
        for i in range(len(gas)):
            total += gas[i] - cost[i]
            curTotal += gas[i] - cost[i]
            if curTotal < 0:
                curTotal = 0
                next = i + 1
        return next if total >= 0 else -1