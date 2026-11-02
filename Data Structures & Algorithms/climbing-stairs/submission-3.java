class Solution {
    public int climbStairs(int n) {
        int one = 1;
        int two = 1;
        for (int i =n-1; i>0;i--) {
            int kopija_one = one;
            one = one+two;
            two=kopija_one;
        }

        return one;
    }
}
