class Solution:
    def findDuplicate(self, nums: List[int]) -> int:
        nums.sort()
        prethodni = 0
        for i in nums:
            if prethodni!=0 and prethodni>=i:
                return i
            prethodni = i