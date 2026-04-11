class Solution:
    def search(self, nums: List[int], target: int) -> int:
        kopija = nums
        levo = 0
        desno = len(nums)-1
        while levo<=desno:
            medijana = (levo+desno)//2
            if target==nums[medijana]:
                return kopija.index(nums[medijana])
            elif target in nums[levo:medijana]:
                nums = nums[levo:medijana]


            elif target in nums[medijana+1: desno+1]:
                nums = nums[medijana + 1:desno + 1]

            else:
                return -1
            levo = 0
            desno = len(nums)-1