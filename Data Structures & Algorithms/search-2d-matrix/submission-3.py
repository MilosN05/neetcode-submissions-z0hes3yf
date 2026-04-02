class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        levo = 0
        desno = len(matrix)-1
        poslednjaVrsta=None
        while levo<=desno:
            medijana = (levo+desno)//2
            if matrix[medijana][0]>target:
                desno=medijana-1
                if levo <= desno:
                    poslednjaVrsta = matrix[medijana]

            elif matrix[medijana][0]<target:
                levo=medijana+1
                poslednjaVrsta = matrix[medijana]
            else: return True
            

        if poslednjaVrsta==None:
            return False

        
        levo2 = 0
        desno2 = len(poslednjaVrsta)-1
        while levo2 <= desno2:
            medijana = (levo2 + desno2) // 2
            if poslednjaVrsta[medijana] > target:
                desno2 = medijana - 1

            elif poslednjaVrsta[medijana] < target:
                levo2 = medijana + 1
            else:
                return True

        return False