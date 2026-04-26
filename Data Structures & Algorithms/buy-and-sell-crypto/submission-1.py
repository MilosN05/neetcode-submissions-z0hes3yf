class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        profit = 0
        levo = 0
        i=0

        while i<len(prices):
            trProfit=prices[i]-prices[levo]
            if trProfit>profit:
                profit = trProfit

            if prices[levo]>prices[i]:
                levo+=1
            else:
                i+=1

        return profit