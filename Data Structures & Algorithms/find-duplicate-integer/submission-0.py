class Solution:
    def findDuplicate(self, nums: List[int]) -> int:
        lista = []

        for i in nums:
            if i not in lista:
                lista.append(i)
            else:
                return i