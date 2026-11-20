class Solution {

    int[] opljackanoU;
    public int rob(int[] nums) {

        if (nums.length==1)
            return nums[0];
        opljackanoU = new int[nums.length];

        for (int i=0;i<nums.length;i++) {
            opljackanoU[i]=-1;
        }
        int levo =robHelp(nums, 0, nums.length-1);
         for (int i=0;i<nums.length;i++) {
            opljackanoU[i]=-1;
        }
        int desno =robHelp(nums, 1, nums.length);

        return Math.max(levo,desno);
    }

    private int robHelp(int[] nums, int i, int max_duzina_niza ) {
        if (i>=max_duzina_niza)
            return 0;

        if (opljackanoU[i]!=-1)
            return opljackanoU[i];
        opljackanoU[i] =Math.max(robHelp(nums, i+1,max_duzina_niza),nums[i]+robHelp(nums,i+2,max_duzina_niza));
        return opljackanoU[i];

        
    }
}
