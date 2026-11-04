class Solution {
    int[] cacheCalculation;
    public int minCostClimbingStairs(int[] cost) {
        cacheCalculation = new int[cost.length];

        for (int i=0;i<cost.length;i++)
            cacheCalculation[i]=-1;
        return Math.min(minCostHelp(cost, 0),minCostHelp(cost, 1));
    }

    public int minCostHelp(int[] cost,   int index) {
        if (index>cost.length)
            return Integer.MAX_VALUE;
        else if (index==cost.length)
            return 0;
        
        

        if (cacheCalculation[index]>=0)
            return cacheCalculation[index];
        
        int levo=minCostHelp(cost,index+1);
        int desno = minCostHelp(cost, index+2);

        cacheCalculation[index]=cost[index] + Math.min(levo,desno);

        return cacheCalculation[index];


    }
}
