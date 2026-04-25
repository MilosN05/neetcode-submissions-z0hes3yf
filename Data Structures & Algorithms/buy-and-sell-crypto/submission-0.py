class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        profit = 0

        for i in range(len(prices)):
            for k in range(i,len(prices)):
                trProfit = prices[k]-prices[i]
                if profit<trProfit:
                    profit = trProfit
        return profit