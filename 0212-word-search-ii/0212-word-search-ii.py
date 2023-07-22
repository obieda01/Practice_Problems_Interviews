class TrieNode:
    def __init__(self):
        self.children = {}
        self.isWord = False
        self.ref = 0
    def addWord(self, word):
        cur = self
        for c in word:
            if c not in cur.children:
                cur.children[c] = TrieNode()
            cur = cur.children[c]
            cur.ref += 1
        cur.isWord = True
    def removeWord(self, word):
        cur = self
        for c in word:
            if c in cur.children:
                cur = cur.children[c]
                cur.ref -= 1
class Solution:
    def findWords(self, board: List[List[str]], words: List[str]) -> List[str]:
        rows, col = len(board), len(board[0])
        root = TrieNode()
        for word in words:
            root.addWord(word)

        visit, res = set(), set()
        def dfs(r, c, word, node):
            if(r < 0 or c < 0 or r >= rows or c >= col 
                or (r, c) in visit or board[r][c] not in node.children
                or node.children[board[r][c]].ref < 1
                
                ):
                return
            visit.add((r,c))
            node = node.children[board[r][c]]
            word += board[r][c]
            if node.isWord:
                res.add(word)
                root.removeWord(word)
                node.isWord = False
            dfs(r + 1, c, word, node)
            dfs(r - 1, c, word, node)
            dfs(r, c + 1, word, node)
            dfs(r, c - 1, word, node)

            visit.remove((r, c))
        
        for i in range(rows):
            for j in range(col):
                dfs(i, j, "", root)
        return list(res)