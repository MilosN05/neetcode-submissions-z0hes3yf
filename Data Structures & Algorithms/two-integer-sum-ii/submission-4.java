class Solution {
    public int[] twoSum(int[] numbers, int target) {
         int pok1 = 0;
        if (numbers.length==2) {
            return new int[]{1,2};
        }
        while (pok1<numbers.length) {

            for (int k=pok1+1;k<numbers.length;k++) {
                int zbir= numbers[pok1]+numbers[k];
                if (zbir==target) {
                    return new int[]{pok1+1,k+1};
                }
                else if (zbir>target)
                    break;

            }
            pok1++;
        }
        return new int[]{};

    }
}
