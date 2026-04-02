class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int pok1 = 0;
        while (pok1<numbers.length) {

            for (int k=pok1+1;k<numbers.length;k++) {
                if (numbers[pok1]+numbers[k]==target) {
                    return new int[]{pok1+1,k+1};
                }

            }
            pok1++;
        }
        return new int[]{};
    }
}
