class Solution:
    def search(self, nums: List[int], target: int) -> int:
        levo = 0
        desno = len(nums)-1


        while levo<=desno:
            medijana = (levo + desno) // 2
            if nums[medijana]<target:
                levo=medijana+1
            elif nums[medijana]>target:
                desno=medijana-1
            else:
                return medijana
        return -1