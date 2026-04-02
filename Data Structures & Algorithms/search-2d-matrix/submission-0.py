class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        levo = 0
        desno = len(matrix)-1

        while levo<=desno:
            medijana = (levo+desno)//2

            dLvD=False
            levo2 = 0
            desno2 = len(matrix[medijana])-1
            while levo2<=desno2:
                medijana2 = (levo2+desno2)//2
                if matrix[medijana][medijana2]<target:
                    levo2=medijana2+1
                    dLvD=True
                elif matrix[medijana][medijana2] > target:
                    desno2=medijana2-1

                else:
                    return True


            if dLvD is True:
                levo=medijana+1
            else:
                desno=medijana-1


        return False