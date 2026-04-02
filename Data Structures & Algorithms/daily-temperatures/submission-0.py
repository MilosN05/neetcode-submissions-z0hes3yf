class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        i =0
        resenje = []
        while i<len(temperatures):
            brojDana =0
            dodato=False
            k=i+1
            while k<len(temperatures):
                brojDana += 1
                if temperatures[k]>temperatures[i]:
                    resenje.append(brojDana)
                    print(brojDana)
                    dodato=True
                    break

                k+=1

            if dodato==False:
                resenje.append(0)
            i+=1
        return resenje