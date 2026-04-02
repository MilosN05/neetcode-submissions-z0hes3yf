class Solution {
   public int[] twoSum(int[] nums, int target) {

        int[] resenje = new int[2];

        int i=0;
        while (i<nums.length) {
            for (int k=i+1;k<nums.length;k++) {
                if (nums[i]+nums[k]-target==0) {
                    resenje[0]=i;
                    resenje[1]=k;
                    break;
                }

        }
            i++;
        }
        return resenje;
    }
}
