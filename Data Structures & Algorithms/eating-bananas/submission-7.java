class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int vremeJela = 0;

        Arrays.sort(piles);
       
        
        int levo = 1;
        int desno = piles[piles.length-1];
        int prethodnoK = 0;
        while (levo<=desno) {
            int vremeZP = 0;

            int medijana = (levo+desno)/2;

            for (int i =0;i<piles.length;i++) {
                int vremeH = piles[i] / medijana;
                int ostatak = piles[i] % medijana;
                if (ostatak != 0)
                    vremeH += 1;
                vremeZP+=vremeH;
            }

            
            if (vremeZP<=h ) {
                desno = medijana-1;
                prethodnoK = medijana;
            }
            else if (vremeZP>h)
                levo = medijana+1;
        }
        return prethodnoK;
    }
}
