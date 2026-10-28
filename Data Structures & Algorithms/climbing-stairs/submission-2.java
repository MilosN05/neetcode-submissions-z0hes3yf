class Solution {
    int[] broj_putanja;
    public int climbStairs(int n) {
        broj_putanja = new int[n];
        return calculateDistinctWays(n, 0);
    }
    public int calculateDistinctWays(int n, int current_sum) {
        
        if (current_sum==n)
            return 1;
        else if (current_sum>n)
            return 0;
        else if (broj_putanja[current_sum]!=0)
            return broj_putanja[current_sum];


        int levo = calculateDistinctWays(n, current_sum+1);
        int desno = calculateDistinctWays(n,current_sum+2);
        broj_putanja[current_sum]=levo+desno;

        return levo+desno;
    }
}
