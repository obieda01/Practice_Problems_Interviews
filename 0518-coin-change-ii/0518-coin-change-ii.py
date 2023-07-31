class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        db =[[0]*(len(coins)+1) for i in range(amount + 1)]
        db[0] = [1]*(len(coins)+1)

        for a in range(amount + 1):
            for c in range(len(coins) -1, -1, -1):
                db[a][c]=db[a][c + 1]
                if a - coins[c] >= 0:
                    db[a][c] += db[a - coins[c]][c]
        return db[amount][0]