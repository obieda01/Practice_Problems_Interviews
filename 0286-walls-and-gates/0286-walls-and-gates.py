class Solution:
    def wallsAndGates(self, rooms: List[List[int]]) -> None:
        """
        Do not return anything, modify rooms in-place instead.
        """
        rows, cols = len(rooms), len(rooms[0])
        visited = set()
        q = deque()
        for r in range(rows):
            for c in range(cols):
                if rooms[r][c] == 0:
                    q.append((r, c))
                    visited.add((r, c))

        directions = [[0, 1], [0, -1],[1, 0], [-1, 0]]
        dest = 0
        while q:
            for i in range(len(q)):
                r, c = q.popleft()
                rooms[r][c] = dest
                
                for dr, dc in directions:

                    row, col = r + dr, c + dc
                    if (
                        row in range(rows) and col in range(cols) and
                        rooms[row][col] == 2147483647 and (row, col) not in visited
                        ):
                            q.append((row, col))
                            visited.add((row, col))
            dest += 1
          