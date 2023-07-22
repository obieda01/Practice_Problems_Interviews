class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        counts = Counter(tasks)
        maxHeap = [-cts for cts in counts.values()]
        heapq.heapify(maxHeap)
        q = deque()
        time = 0
        while q or maxHeap:
            time += 1
            if not maxHeap:
                time = q[0][1]
            else:
                cts = 1 + heapq.heappop(maxHeap)
                if cts:
                    q.append([cts, time + n])

            if q and q[0][1] == time:
                heapq.heappush(maxHeap, q.popleft()[0])
            
        return time

