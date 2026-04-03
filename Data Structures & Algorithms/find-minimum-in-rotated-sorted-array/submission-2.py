class Solution:
    def findMin(self, nums: List[int]) -> int:
        
        min = None
        for i in range(len(nums)):
            if min==None or min>nums[i]:
                min = nums[i]
        return min