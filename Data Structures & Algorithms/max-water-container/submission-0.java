class Solution {
    public int maxArea(int[] heights) {
        int i=0;
        int povrsina =0;
        while (i<heights.length) {

            for (int k=i+1;k<heights.length;k++) {
                int rastojanje = k-i;
                int leva = heights[i];
                int desna = heights[k];

                if (leva>desna)
                    leva=desna;


                int tP = leva*rastojanje;
                if (povrsina<tP)
                    povrsina = tP;

            }

            i++;
        }
        return povrsina;
    }
}
