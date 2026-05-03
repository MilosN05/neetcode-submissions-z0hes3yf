class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        mainHM = {}
        suppHM = {}
        for char in s1:
            mainHM[char] = 1 + mainHM.get(char, 0)

        i=0
        levo = 0

        for char in s2:
            if char not in mainHM:
                levo+=1
                suppHM.clear()
                i=0
                continue


            i+=1
            suppHM[char] = 1 + suppHM.get(char,0)

            while suppHM[char]>mainHM[char]:
                suppHM[s2[levo]]-=1
                levo+=1
                i-=1
            if i==len(s1):
                return True


        return False
        