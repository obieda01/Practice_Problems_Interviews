"""
# Definition for a Node.
class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random
"""

class Solution:
    def copyRandomList(self, head: 'Optional[Node]') -> 'Optional[Node]':
        if not head:
            return None
        cache = {}
        cur = head
        while cur:
            node = Node(cur.val)
            cache[cur] = node
            cur = cur.next
        cur = head
        while cur:
            node = cache[cur]
            node.next = cache[cur.next] if cur.next else None
            node.random = cache[cur.random] if cur.random else None
            cur = cur.next
        return cache[head]
        