class Solution:
    def characterReplacement(self, s: str, k: int) -> int:

        heshmapa = dict()


        l = 0
        maxL = 0
        for i in range(len(s)):
            heshmapa[s[i]] = 1 + heshmapa.get(s[i],0)

            while i-l + 1 - max(heshmapa.values())>k:

                heshmapa[s[l]]-=1
                l += 1
            maxL = max(maxL, i-l+1)
        return maxL