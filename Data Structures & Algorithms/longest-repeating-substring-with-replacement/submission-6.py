class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        levo = 0
        maxL = 0
        heshMapa = {}

        i=0
        for char in s:
            heshMapa[char]=1+heshMapa.get(char, 0)
            i+=1
            while i - max(heshMapa.values())>k:
                heshMapa[s[levo]]-=1
                levo+=1
                i-=1

            maxL = max(i,maxL)


        return maxL