class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int pok1 = 0;
        int[] resenje = new int[2];
        while (pok1<numbers.length) {

            for (int k=pok1+1;k<numbers.length;k++) {
                if (numbers[pok1]+numbers[k]==target) {
                    resenje[0] = pok1+1;
                    resenje[1] = k+1;
                    return resenje;
                }

            }
            pok1++;
        }
        return resenje;
    }
}
