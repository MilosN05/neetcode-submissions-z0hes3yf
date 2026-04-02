class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        nums.sort()

        # if len(nums)==3:
        #     return [[nums[0],nums[1],nums[2]]]

        svaResenja =[]
        pok1 = 0



        while (pok1<len(nums)-2):
            if pok1>0 and nums[pok1]==nums[pok1-1]:
                pok1+=1
                continue
            pok2 = len(nums) - 1
            cilj = (-1)*nums[pok1]
            srednjiPok =pok1+1
            while srednjiPok<pok2:

                zbir = nums[pok2]+nums[srednjiPok]
                # print(zbir, f"{nums[pok1]}, {nums[srednjiPok]}, {nums[pok2]}")

                if zbir==cilj:
                    svaResenja.append([nums[pok1],nums[srednjiPok],nums[pok2]])

                    srednjiPok+=1
                    pok2-=1
                    while srednjiPok<pok2 and nums[srednjiPok]==nums[srednjiPok-1]: srednjiPok+=1
                    while srednjiPok<pok2 and pok2<len(nums)-1 and nums[pok2]==nums[pok2+1]: pok2-=1;


                elif zbir<cilj:
                    srednjiPok+=1
                elif zbir>cilj:
                    pok2-=1

            pok1+=1

        return svaResenja