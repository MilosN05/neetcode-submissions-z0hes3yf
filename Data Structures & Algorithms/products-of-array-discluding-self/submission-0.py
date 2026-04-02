class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        resenje = nums.copy()
        i =0
        while i<len(nums):
            proizvod =1

            for k in range(len(nums)):
                if k!=i:
                    proizvod*=nums[k]
            resenje[i]=proizvod
            i+=1

        return resenje