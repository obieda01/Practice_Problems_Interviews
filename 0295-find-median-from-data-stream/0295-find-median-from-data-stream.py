class MedianFinder:
    
    def __init__(self):
        self.s, self.l = [], []    

    def addNum(self, num: int) -> None:
        if self.l and num > self.l[0]:
            heapq.heappush(self.l, num)
        else:
            heapq.heappush(self.s, num * -1)
        if len(self.s) < len(self.l)+1:
            val = heapq.heappop(self.l)
            heapq.heappush(self.s, val * -1)
        if len(self.s) > len(self.l)+1:
            val = heapq.heappop(self.s)
            heapq.heappush(self.l, val * -1)

        

    def findMedian(self) -> float:
        if len(self.s) > len(self.l):
            return self.s[0] * -1
        elif len(self.s) < len(self.l):
            return self.l[0] 
        else:
            return ((self.s[0] * -1) + self.l[0])/2


        


# Your MedianFinder object will be instantiated and called as such:
# obj = MedianFinder()
# obj.addNum(num)
# param_2 = obj.findMedian()