class Solution {
    public static void quicksort(int[] niz, int[]niz2, int pocetak, int kraj) {



        if (pocetak>=kraj)
            return;

        int pivot=particija(niz, niz2,pocetak,kraj);
        quicksort(niz, niz2, pocetak,pivot-1);
        quicksort(niz, niz2,pivot+1,kraj);
    }
    public static int particija(int[]niz,int[]niz2,int pocetak, int kraj) {

        int i=pocetak-1;

        for (int j=pocetak;j<kraj;j++) {
            if (niz[j]<niz[kraj]) {
                i++;
                int temp = niz[j];
                niz[j]=niz[i];
                niz[i]=temp;

                int temp2 = niz2[j];
                niz2[j]=niz2[i];
                niz2[i]=temp2;


            }
        }

        i++;
        int temp = niz[i];
        niz[i] = niz[kraj];
        niz[kraj] =temp;


        int temp2 = niz2[i];
        niz2[i] = niz2[kraj];
        niz2[kraj] =temp2;
        return i;

    }
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

    public int carFleet(int target, int[] position, int[] speed) {
        int brojFlota =0;
        double vremePoslednjeg = 0;

        int i=0;

        quicksort(position,speed,0,position.length-1);




        for (i=position.length-1;i>=0;i--) {
            double trenutnoVreme = (double)(target - position[i])/speed[i];
            System.out.println(vremePoslednjeg + ": " + trenutnoVreme + "  POZICIJA: " + position[i] + " BRZINA: "+ speed[i]);

            if (vremePoslednjeg==0 || trenutnoVreme>vremePoslednjeg) {
                vremePoslednjeg=trenutnoVreme;
                brojFlota+=1;
            }
        }

        return brojFlota;
    }
}
