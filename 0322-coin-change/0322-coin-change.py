class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        db = [float('inf')]*(amount + 1)
        db[0] = 0
        for a in range(1, amount + 1):
            for c in coins:
                if a - c >= 0:
                    db[a] = min(db[a], 1 + db[a - c])
        return db[amount] if db[amount] != float('inf') else -1