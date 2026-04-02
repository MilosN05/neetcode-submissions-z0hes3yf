class Solution {
    int broj =-2000;
    int brojPojavljivanja = 1;
    public int[] topKFrequent(int[] nums, int k) {
        Arrays.sort(nums);
        Solution obj = new Solution();


        Solution[] pojavljivanja = new Solution[nums.length];
        int brojac =0;

        for (int i=0;i<nums.length;i++) {
            if (obj.broj!=nums[i]) {
                obj = new Solution();
                obj.broj = nums[i];
                pojavljivanja[brojac++] = obj;
            }
            else
                obj.brojPojavljivanja++;
        }


        int s=0;
        while (s<brojac) {
            for (int i=0;i<brojac;i++) {
                if (pojavljivanja[s].brojPojavljivanja>pojavljivanja[i].brojPojavljivanja) {
                    Solution replika = pojavljivanja[s];
                    pojavljivanja[s]=pojavljivanja[i];
                    pojavljivanja[i]=replika;
                }
            }
            s++;
        }

        int[] resenje=new int[k];

        for (int i=0;i<k;i++) {
            resenje[i]=pojavljivanja[i].broj;
        }
        return resenje;
    }
}
