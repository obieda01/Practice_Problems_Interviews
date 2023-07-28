class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        map = {i:[] for i in range(numCourses)}
        visit = set()
        for cr, pr in prerequisites:
            map[cr].append(pr)
        
        def dfs(crs):
            if crs in visit:
                return False
            if map[crs] == []:
                return True
            
            visit.add(crs)
            for pr in map[crs]:
                if not dfs(pr):
                    return False
            visit.remove(crs)
            map[crs] = []
            return True
        for crs in range(numCourses):
            if not dfs(crs):
                return False
        return True
