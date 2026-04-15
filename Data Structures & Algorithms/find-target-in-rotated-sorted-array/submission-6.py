class Solution:
    def search(self, nums: List[int], target: int) -> int:
        levo = 0
        desno = len(nums)-1

        if levo==desno and nums[0]==target:
            return 0
        elif levo==desno:
            return -1
        polovina = -1
        while levo<=desno:
            medijana = (levo+desno)//2

            if nums[medijana] > nums[desno]:
                levo = medijana + 1
            elif nums[medijana]<nums[medijana-1]:
                polovina= medijana
                break
            else:
                desno=medijana-1


        levo=0
        desno = polovina-1
        for i in range(0,2):
            while levo<=desno:
                medijana = (levo+desno)//2

                if nums[medijana]<target:
                    levo = medijana+1
                elif nums[medijana]>target:
                    desno = medijana-1
                else:
                    return medijana
            levo = polovina
            desno = len(nums)-1
        return -1