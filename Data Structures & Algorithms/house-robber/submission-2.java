class Solution {
    int[] maxOpljackati;
    public int rob(int[] nums) {
        maxOpljackati = new int[nums.length];
        for (int i=0;i<nums.length;i++) {
            maxOpljackati[i]=-1;
        }
        return robHelp(nums, 0);
    }
    private int robHelp(int[] nums, int i) {
        if (i>=nums.length)
            return 0;
        if (maxOpljackati[i]!=-1)
            return maxOpljackati[i];

        
        maxOpljackati[i]=Math.max(robHelp(nums, i+1),nums[i] + robHelp(nums, i+2));
        return maxOpljackati[i];
    }
}
