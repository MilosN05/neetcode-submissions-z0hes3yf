class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        nums.sort()
        noviNiz =[]

        prethodnik=None
        najduzeDoSad = 0

        while len(nums)!=0:
            trenutni = nums[0]
            if prethodnik is None or trenutni-prethodnik==1:
                noviNiz.append(trenutni)
                prethodnik = trenutni
                nums = nums[1:]
            elif trenutni-prethodnik>1:
                if najduzeDoSad<len(noviNiz):
                    najduzeDoSad = len(noviNiz)
                prethodnik=None
                noviNiz=[]
            else:
                nums = nums[1:]


        return najduzeDoSad if najduzeDoSad>len(noviNiz) else len(noviNiz)