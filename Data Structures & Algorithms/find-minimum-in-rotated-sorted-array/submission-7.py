class Solution:
    def findMin(self, nums: List[int]) -> int:
        if len(nums)==1:
            return nums[0]
        i =0
        j = len(nums)-1
        while i<=j:
            medijana = (i+j)//2

            if nums[medijana]>nums[j]:
                i=medijana+1
            elif nums[medijana]<nums[j]:
                if nums[medijana]<nums[medijana-1]:
                    return nums[medijana]
                j=medijana-1

            else:

                return nums[medijana]