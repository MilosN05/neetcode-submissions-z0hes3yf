class Solution {
    public int maxProfit(int[] prices) {
        int profit =0;
        boolean prebaceno=false;
        int i=0;
        while(i<prices.length) {
            int trSuma=0;
            for (int k=i+1;k<prices.length;k++) {
                trSuma=prices[k]-prices[i];

                if (trSuma>profit)
                    profit=trSuma;
                else if (trSuma<=0) {
                    i=k;
                    prebaceno=true;
                    break;
                    }
            }
            if (prebaceno==false)
                 i++;
            else
                prebaceno=false;
        }
        return profit;
    }
}
